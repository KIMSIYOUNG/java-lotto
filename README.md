## 로또 미션을 위한 저장소

---

## 게임 순서

- 구입 금액을 입력 받는다.

    - 1000단위가 아닌 경우는 예외처리
    - 문자열이 포함되는 경우 예외처리
    - 공백 및 NULL 예외처리
    - 1000원 ~ 100,000원까지만 가능
    - 구입 금액 또한 클래스로 분리하고
        - 기능은 생성자를 통한 검증
        - 장수를 계산해서 보내는 부분도

- 금액 / 1000 의 갯수만큼 로또를 자동으로 생성 및 출력한다.

    - Number : 각각의 수
        - 1~45 사이의 값인지
        - 문자열이 포함되는 경우 예외처리
        - 공백 및 NULL 예외처리
    - Number를 6개 가지고 있는 로또 한 장을 지칭하는 객체(Lotto)
        - `Lotto.size()` = 6
        - 중복된 수가 있으면 안된다.
    - Lotto 를 금액 / 1000만큼 생성한다.
        - Lotto를 구매한 만큼 가지고 있는 Lottos 객체를 생성한다.
            - 금액 / 1000 == Lottos.size()
    - 이렇게 생성된 Lottos 를 출력한다.

- 당첨번호(보너스 번호 제외) 6자리를 `,` 를 기준으로 분리한다.
    - 싱글톤 ?
    - 당첨번호를 담당하는 WinningLotto 객체를 생성한다.
    - 공백 및 NULL 예외처리
    - 데이터 타입 처리
    - 갯수 6개
    - 번호의 범위
    - 각각 다른 번호인지

- 보너스 볼 하나를 입력한다
    - 보너스 볼 객체 Bonus
    - Number 하나를 갖는 객체

- 당첨 통계를 출력한다
    - LottoModel ← Lottos , Winning
    - OutputView
    - Enum 에서 맞힌 갯수, 금액, 몇장인지를 가지는 Enum에서 처리

- 참고
    - 숫자를 생성할 때 그리고 보너스 넘버를 생성할 때 로직이 겹치니까 해결책으로
        - Validator를 따로 둔다.
        - Number를 상속받는다.

### 구현 순서

- 구입 금액 테스트
    - [x] 1000단위가 아닌 경우는 예외처리
    - [x] 문자열이 포함되는 경우 예외처리
    - [x] 공백 및 NULL 예외처리
    - [x] 1000원 ~ 100,000원까지만 가능
    - [x] 장수로 변환하는 매소드 추가
- Utility 클래스 검증
    - [x] 공백 제거
    - [x] `,` Parsing 검증
    
- Number
    - [x] 1~45 사이의 값인지
    - [x] 문자열이 포함되는 경우 예외처리
    - [x] 공백 및 NULL 예외처리
    - Enum을 통해서 Number 기능을 같이 하는 방안 고려 (현재 static 부분)
    
- LottoFactory
    
- Lotto
    - [x] `Lotto.size()` = 6
    - [x] 중복된 수가 있으면 안된다.
        
- Lottos
    - [x] Lotto를 구매한 만큼 가지고 있는 Lottos 객체를 생성한다
    - [x] 금액 / 1000 == Lottos.size()    

- WinningLotto
    - [x] 보너스넘버와 WinningNumbers의 값이 겹치지 않아야 한다.
    - [x] BonusNumber (상속 : Number)
    - [x] WinningNumbers
        - [x] 상속받고 있고 (Lotto) : 로직이 같고, 로또와 의미를 구분하기 위함
        
- Result
    - 인자 : WinningLotto, Lottos
    - 기능
        - 맞힌 갯수별로 장수 + 수익금 계산
        - 수익률
        - OutputView 보내기         
        
### 프로그래밍 요구사항

- indent(인덴트, 들여쓰기) depth를 2단계에서 1단계로 줄여라.
    - depth의 경우 if문을 사용하는 경우 1단계의 depth가 증가한다. if문 안에 while문을 사용한다면 depth가 2단계가 된다.
- else를 사용하지 마라.
- 메소드의 크기가 최대 10라인을 넘지 않도록 구현한다.
    - method가 한 가지 일만 하도록 최대한 작게 만들어라.
- **배열 대신 ArrayList를 사용한다.**
- enum을 적용해 프로그래밍을 구현한다.

### 힌트

- 로또 자동 생성은 Collections.shuffle() 메소드 활용한다.
- Collections.sort() 메소드를 활용해 정렬 가능하다.
- ArrayList의 contains() 메소드를 활용하면 어떤 값이 존재하는지 유무를 판단할 수 있다.