<h1 align="center">Coroutine</h1>

# summary
코루틴 학습 프로젝트

## withContext와 CoroutineScope의 차이

# withContext
withContext는 새로운 Scope를 생성하지 않고, 부모 코루틴과 동일한 생명주기를 가진다.
예를 들어 아래와 같은 코드가 있으면
```kotlin
fun testWithContextAndCoroutineScope() = viewModelScope.launch {
    withContext(Dispatchers.IO) {
        delay(5000)
        Log.d("test", "withContext reached")
    }
    delay(2000)
    Log.d("test", "End viewModelScope")
}
```
5초 후에 "withContext reached" 로그가 발생하고 2초 후에 "End viewModelScope"가 발생한다.
이는 withContext 스코프가 suspend하고 순차적(sequencial)으로 실행하는 것을 알 수 있다

# CoroutineScope
CoroutineScope는 새로운 Scope를 생성하며, 독립적인 생명주기를 가진다.
예를 들어 아래와 같은 코드가 있으면
```kotlin
fun testWithContextAndCoroutineScope() = viewModelScope.launch {
    CoroutineScope(Dispatchers.IO).launch {
        delay(5000)
        Log.d("test", "CoroutineScope reached")
    }

    delay(2000)
    Log.d("test", "End viewModelScope")
}
```
2초 후에 "End viewModelScope"가 발생하고 3초 후에 "CoroutineScope reached"가 발생한다.
이는 CoroutineScope의 독립적인 성격을 그대로 반영한 결과이다.
withContext와 다르게 부모 코루틴의 생명주기에 영향을 받지 않으며,
부모 코루틴이 중지되어도 CoroutineScope의 작업은 끝까지 진행된다.


# 정리
withContext는 부모코루틴의 컨텍스트를 상속받아 순차적(sequential)으로 실행된다.
CoroutineScope는 새로운 컨텍스트를 생성해서 병렬적(parallel)으로 실행된다.
