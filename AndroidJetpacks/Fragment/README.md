# Fragment
## Fragment Container
### FrameLayout
여러 화면을 겹쳐 넣을 수 있음. 액자 틀 구조 (액자 = FrameLayout, 사진 = Fragment)
### FragmentContainerView
[FragmentContainerView 사용 이유](https://www.charlezz.com/?p=23496)
### Fragment
[Fragment 와 FrameLayout](https://velog.io/@deepblue/fragment%EC%99%80-FrameLayout-%ED%83%9C%EA%B7%B8)
# 다양한 방법으로 Fragment 호출하기(FragmentManager)
## ✍ beginTransaction()
```kotlin
private val basicFragment by lazy {
        BasicFragment()
    }

supportFragmentManager.beginTransaction()
    .replace(R.id.fragment_container, basicFragment)
    .commit()
```
Fragment 는 lazy 를 사용하여 메모리를 효율적으로 사용할 수 있었다.
### 데이터 전송하기 (Activity -> Fragment)
```kotlin
val bundle = Bundle()
bundle.putBundle("basic_bundle", bundleOf("basic_int" to 1))
basicFragment.arguments = bundle
supportFragmentManager.beginTransaction()
    .replace(R.id.fragment_container, basicFragment)
    .commit()
```
### 데이터 전송받기 (Fragment)
```kotlin
val arg = requireArguments().getBundle("basic_bundle")
```
```kotlin
val arg = arguments?.getBundle("basic_bundle")
```
## ✍ commit()
우선 commit() 사용하기 위해서는 implementaion 추가를 해야 한다.
```kotlin
implementation "androidx.fragment:fragment-ktx:1.5.5"
```
```kotlin
supportFragmentManager.commit {
    replace<SaveInstanceFragment>(R.id.fragment_container)
    setReorderingAllowed(true)
    addToBackStack("name")
}
```
🔍setReorderingAllowed(true) : 애니메이션 전환이 올바르게 작동하도록 트랜잭션과 관련된 프래그먼트의 상태 변경을 최적화  
🔍addToBackStack() : 인자로 String 이나 null 을 받는다.
### 데이터 전송하기 (Activity -> Fragment)
```kotlin
val bundle = bundleOf("some_int" to 0)
replace<SaveInstanceFragment>(R.id.fragment_container)
supportFragmentManager.commit {
    replace<SaveInstanceFragment>(R.id.fragment_container, args=bundle)
    setReorderingAllowed(true)
    addToBackStack("name")
}
```
### 데이터 수신받기는 위 beginTransaction() 에서 참조하자.

```text
❗ 추가적으로 알아두면 좋은 savedInstanceState 사용하기   

👆 사용하는 이유는?   

null 처리를 해주는 이유는 앱이 강제 종료되거나 가로-세로모드로 변환될 때 savedInstanceState 는 
다음 화면 호출 시 null 값이 아니다. 
그렇기 대문에 null 체크를 프래그먼트 호출 시 해준다면 매번 가로-세로모드로 변경될 때마다 프래그먼트 호출을 안할 수 있다.
```
### savedInstanceState
해당 객체는 **onCreate()** 에서만 사용할 수 있다.
```kotlin
    override fun onCreate(savedInstanceState: Bundle?) {
        if (savedInstanceState == null){
            // null 일 때는 프래그먼트 호출
        } 
        else {
            // null 아닐 때는 원하는 이벤트 처리
        }
    }

```
## ✍ newInstance (AndroidX 부터는 instantiate) 
```text
👆 사용하는 이유?   

프래그먼트를 상속받을 때 인자가 없는 기본 생성자를 반드시 포함해야 한다.
또한, 프래그먼트는 자기만의 라이프사이클을 가지고 있지만 액티비티 라이프사이클에 종속적임을 알 수 있다. 
따라서 메모리가 부족하거나 화면회전, 디스플레이 변경 등의 다양한 이벤트로 액티비티가 재생성 될 때 
프래그먼트도 재생성이 된다.  

결론은 결국 프래그먼트의 잦은 재생성으로 이를 해결하기 위한 방법은 newInstace() 를 활용하는 것
```
MainActivity.kt
```kotlin
private val instanceFragment by lazy {
    InstanceFragment.newInstance()
}

supportFragmentManager.beginTransaction()
    .replace(R.id.fragment_container, instanceFragment)
    .commit()
```
InstaceFragment.kt
```kotlin
companion object {
    fun newInstance(): InstanceFragment {
        val fragment = InstanceFragment()
        val args = Bundle()
        args.putBundle("bundle_instance", bundleOf("bundle_instance" to 2))
        fragment.arguments = args
        return fragment
    }
}

```
## ✍ FragmentFactory 사용하기 
```text
👆 사용하는 이유?   

위에서 설명했던 AndroidX 부터는 instantiate()는 deprecated 되었고 FragmentFactory의 instantiate() 를 사용해 구현하라고 Android Developer 공식문서에 나와있다. 

위 방법을 사용하는 이유는 기존에는 프래그먼트에 빈 생성자가 없다면 구성변경 및 앱의 프로세스 재생성과 같은 특정 상황에서 시스템은 프래그먼트를 초기화 하지 못했다. 
이 점을 해결하기 위해 FragmentFactory를 사용하게 되었고 Fragment에 필요한 인수 및 종속성을 제고하여 시스템이 Fragment를 더욱 잘 초기화하는데 도움을 준다.

참고한 링크 : https://imwj.notion.site/FragmentFactory-8f3ad6874e9d43eba0af054b72b5a738

추가적으로 koin 을 사용하여 간편하게 FragmentFactory 를 이용하자.
https://insert-koin.io/docs/reference/koin-android/fragment-factory/
```
FragmentFactoryImpl.kt
```kotlin
class FragmentFactoryImpl(private val age: Int): FragmentFactory() {
    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        return when (className){
            OneFragment::class.java.name -> {
                OneFragment()
            }
            TwoFragment::class.java.name -> {
                TwoFragment().apply {
                    arguments = Bundle().apply {
                        putBundle("bundle_two", bundleOf("bundle_two" to age))
                    }
                }
            }
            ThreeFragment::class.java.name -> {
                ThreeFragment().apply {
                    arguments = Bundle().apply {
                        putBundle("bundle_three", bundleOf("bundle_three" to age))
                    }
                }
            }
            else -> return super.instantiate(classLoader, className)
        }
    }
}
```
MainActivity.kt
```kotlin
private lateinit var fragment: Fragment

override fun onCreate(savedInstanceState: Bundle?) {
    supportFragmentManager.fragmentFactory = FragmentFactoryImpl(100)

    fragment = supportFragmentManager.fragmentFactory.instantiate(classLoader, OneFragment::class.java.name)   

    supportFragmentManager.beginTransaction()
        .replace(R.id.fragment_container, fragment)
        .commitNow()
}
```
- - -
# Fragment Transaction
✋**Fragment Transaction 이란?**   
: Run-Time 에 FragmentManager 로 사용자 상호 작용에 대한 응답을 프래그먼트로 사용하여 다른 작업을 추가, 제거, 교체 등 수행할 수 있다.
각 프래그먼트에 변경된 변경사항 집합을 Fragment Transaction 라는 단일 단위로 commit() 되어진다. 즉, 여러 작업을 단일 트랜잭션 으로 그룹화할 수 있다. (예를 들면, 트랜잭션은 여러 프래그먼트를 추가하거나 교체할 수 있다.)   

**인스턴스 가져오기**
```kotlin
val fragmentManager = ...
val fragmentTransaction = fragmentManager.beginTransaction()
```

**모든 작업을 트랜잭션에 추가하기 (commit)**
```kotlin
val fragmentManager = ...
val fragmentTransaction = fragmentManager.beginTransaction()
	...
	.commit()
```
commit() 메서드는 **비동기적**으로 동작한다.

**fragment-ktx dependencies 사용하면**
```kotlin
val fragmentManager = ...
// The fragment-ktx module provides a commit block that automatically
// calls beginTransaction and commit for you.
fragmentManager.commit {
    // Add operations here
}
```

**commitNow() 메서드 사용하기**
```kotlin
supportFragmentManager.beginTransaction()
    .replace(R.id.fragment_containter_view, commitFragment)
    .commitNow()
```
commitNow() 메서드는 즉시 실행되며 addToBackStack 과 호환되지 않는다.

### ✍ 프래그먼트 추가, 삭제 및 변경
**프래그먼트 추가하기**
```text
✋add() 메서드 사용
프래그먼트를 액티비티 위에 추가해주는 것이다. 해당 프래그먼트를 사라지지 않고 스택처럼 남아있다. 
그렇기 때문에 또 add() 메서드로 같은 프래그먼트를 추가하면

Fragment already added: <- 와 같은 에러가 발생한다.

🚀add 의 생명주기
onCreate() - onCreateView() - onViewCreated() - onStart() - onResume()
```
```kotlin
supportFragmentManager.beginTransaction()
    .add(R.id.fragment_containter_view, addFragmentOne)
    .commit()
```
아래 코드처럼 fragments 를 확인하면 두 개의 프래그먼트가 쌓인 것을 확인할 수 있다.
```kotlin
supportFragmentManager.fragments
>>>
[AddFragmentOne{19f4858} (087fe2c5-057f-45e6-887d-8d0422d6346e id=0x7f0800ce), 
AddFragmentTwo{4eccdb1} (a227ed0b-5948-403b-8942-d804d0a67a44 id=0x7f0800ce)]
```
**프래그먼트 삭제하기**
```text
✋remove() 메서드 사용
스택에 남아있는 프래그먼트를 태그(Tag)를 이용해서 삭제할 수 있다.

🚀remove 의 생명주기
onPause() - onStop() - onDestroyView() - onDestroy()
```
```kotlin
supportFragmentManager.beginTransaction()
    .add(R.id.fragment_containter_view, addFragmentOne, "oneFragment")
    .commit()
```
```kotlin
val oneFragment = supportFragmentManager.findFragmentByTag("oneFragment")
    if (oneFragment != null){
        supportFragmentManager.beginTransaction()
            .remove(oneFragment)
            .commit()
    } else {
        Log.d("로그", "oneFragment no exist")
    }
```
**프래그먼트 변경하기**
```text
✋replace() 메서드 사용
해당 프래그먼트를 제일 우선순위로 호출하며 남아있는 프래그먼트가 있다면 삭제한다.

🚀쌓여있던 프래그먼트 생명주기
onPause() - onStop() - onDestroyView() - onDestroy()

🚩스택에 남은 프래그먼트는 오직 하나
[AddFragmentOne{53dd0a3} (f5d7de2c-e15f-43a1-916c-52bf659b0e39 id=0x7f0800ce tag=oneFragment)]
```
```kotlin
supportFragmentManager.beginTransaction()
    .add(R.id.fragment_containter_view, addFragmentOne, "oneFragment")
    .commit()

supportFragmentManager.beginTransaction()
    .add(R.id.fragment_containter_view, addFragmentTwo, "twoFragment")
    .commit()

val oneFragment = supportFragmentManager.findFragmentByTag("oneFragment")
    if (oneFragment != null){
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_containter_view, oneFragment)
            .commit()
    } else {
        Log.d("로그", "oneFragment no exist")
    }
```
**추가로 백스택에 추가**
```text
✋addToBackStack() 메서드 사용

A프래그먼트를 삭제 또는 A프래그먼트로 변경 시 onDestroy() 메서드가 호출되며 프래그먼트의 생명주기 끝까지 가는 것을 알 수 있다. 
하지만 addToBackStack() 메서드를 사용하면 다르다.
```
코드로 알아보자
```kotlin
supportFragmentManager.beginTransaction()
    .add(R.id.fragment_containter_view, addFragmentTwo, "twoFragment")
    .addToBackStack(null)
    .commit()
```
```kotlin
val oneFragment = supportFragmentManager.findFragmentByTag("oneFragment")
    if (oneFragment != null){
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_containter_view, oneFragment)
            .commit()
    } else {
        Log.d("로그", "oneFragment no exist")
    }
```
```text
🚀동작되는 프래그먼트의 생명주기

onPause() - onStop() - onDestroyView()
onDestroyView() 까지만 호출되는 것을 알 수 있다.
```
## ✍프래그먼트에서 뒤로가기 버튼 시 이벤트 처리
```TEXT
✋Activity 의 onBackPressedDispatcher 를 호출한다.
  호출 후 인자로 callback 넣어주면 이벤트 처리를 할 수 있다.
```
아래 코드처럼 A 액티비티 내 A 프래그먼트가 불리고, A 프래그먼트에서 어떤 이벤트로 인하여 B 프래그먼트가 add 되었을 때, 
B 프래그먼트에서 뒤로가기 버튼을 눌렀을 때 A 프래그먼트로 돌아가는 방법
```kotlin
private fun onBackPressed(){
        requireActivity().onBackPressedDispatcher.addCallback(this, object: OnBackPressedCallback(true){
            override fun handleOnBackPressed() {
                val searchFragment = parentFragmentManager.findFragmentByTag("SearchFragment")
                if (searchFragment != null ){
                    parentFragmentManager.beginTransaction()
                        .remove(searchFragment)
                        .commit()
                }
            }
        })
    }
```
# 프래그먼트 생명주기
![image](https://user-images.githubusercontent.com/90740783/226173051-28ad36cc-2bc4-4b0f-aa73-a0affbcf8741.png)

