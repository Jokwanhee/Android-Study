# Fragment
## Fragment Container
### FrameLayout
여러 화면을 겹쳐 넣을 수 있음. 액자 틀 구조 (액자 = FrameLayout, 사진 = Fragment)
### FragmentContainerView
[FragmentContainerView 사용 이유](https://www.charlezz.com/?p=23496)
### Fragment
[Fragment 와 FrameLayout](https://velog.io/@deepblue/fragment%EC%99%80-FrameLayout-%ED%83%9C%EA%B7%B8)
## 다양한 방법으로 Fragment 호출하기
## beginTransaction()✍
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
## commit()✍
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

null 처리를 해주는 이유는 앱이 강제 종료되거나 가로-세로모드로 변환될 때 savedInstanceState 는 다음 화면 호출 시 null 값이 아니다. 그렇기 대문에 null 체크를 프래그먼트 호출 시 해준다면 매번 가로-세로모드로 변경될 때마다 프래그먼트 호출을 안할 수 있다.
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
## newInstance (AndroidX 부터는 instantiate)
```text
👆 사용하는 이유?   

프래그먼트를 상속받을 때 인자가 없는 기본 생성자를 반드시 포함해야 한다. 또한, 프래그먼트는 자기만의 라이프사이클을 가지고 있지만 액티비티 라이프사이클에 종속적임을 알 수 있다. 따라서 메모리가 부족하거나 화면회전, 디스플레이 변경 등의 다양한 이벤트로 액티비티가 재생성 될 때 프래그먼트도 재생성이 된다.  

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
## FragmentFactory 사용하기
```text
👆 사용하는 이유?   

위에서 설명했던 AndroidX 부터는 instantiate()는 deprecated 되었고 FragmentFactory의 instantiate() 를 사용해 구현하라고 Android Developer 공식문서에 나와있다. 

위 방법을 사용하는 이유는 기존에는 프래그먼트에 빈 생성자가 없다면 구성변경 및 앱의 프로세스 재생성과 같은 특정 상황에서 시스템은 프래그먼트를 초기화 하지 못했다. 이 점을 해결하기 위해 FragmentFactory를 사용하게 되었고 Fragment에 필요한 인수 및 종속성을 제고하여 시스템이 Fragment를 더욱 잘 초기화하는데 도움을 준다.

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
