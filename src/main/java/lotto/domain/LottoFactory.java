package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import lotto.util.StringUtil;

public class LottoFactory {

	public static final int LOWER_BOUND = 0;
	public static final int UPPER_BOUND = 6;

	/**
	 * 로또 한장을 만드는 메소드
	 * @return Lotto
	 */
	public static Lotto create() {
		List<Number> numbers = Number.getNumbers();
		Collections.shuffle(numbers);
		return new Lotto(numbers.subList(LOWER_BOUND, UPPER_BOUND));
	}

	/**
	 * 당첨 로또를 생성하는 메소
	 * @param winningNumbers
	 * @return Lotto
	 */
	public static Lotto create(String winningNumbers) {
		List<String> numbers
			= StringUtil.parseByComma(StringUtil.removeBlank(winningNumbers));
		List<Number> lotto = numbers.stream()
			.map(Number::of)
			.collect(Collectors.toList());
		Collections.shuffle(lotto);
		return new Lotto(lotto);
	}

	/**
	 * 구매한 금액만큼 자동으로 로또 여러장을 생성하는 메소드
	 * @param count
	 * @return Lottos
	 */
	public static Lottos create(int count) {
		List<Number> numbers = Number.getNumbers();
		List<Lotto> lottos = new ArrayList<>();
		for (int i = 0; i < count; i++) {
			Collections.shuffle(numbers);
			lottos.add(new Lotto(numbers.subList(LOWER_BOUND, UPPER_BOUND)));
		}
		return new Lottos(lottos);
	}
}