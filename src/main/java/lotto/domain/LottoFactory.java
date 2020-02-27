package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import lotto.util.StringUtil;

public class LottoFactory {
	public static final int LOWER_BOUND = 0;
	public static final int UPPER_BOUND = 6;

	public static Lotto createAuto() {
		List<Number> numbers = Number.getNumbers();
		Collections.shuffle(numbers);
		return new Lotto(numbers.subList(LOWER_BOUND, UPPER_BOUND));
	}

	public static Lotto createManual(String winningNumbers) {
		List<String> numbers
			= StringUtil.parseToNumbers(StringUtil.removeBlank(winningNumbers));
		List<Number> lotto = numbers.stream()
			.map(Number::of)
			.collect(Collectors.toList());
		Collections.shuffle(lotto);
		return new Lotto(lotto);
	}

	public static Lottos createAutosOf(int count) {
		List<Lotto> lottos = new ArrayList<>();
		for (int i = 0; i < count; i++) {
			lottos.add(createAuto());
		}
		return new Lottos(lottos);
	}

	public static Lottos createManualsAndAutos(List<String> manualLottoInput, int autoLottoCount) {
		List<Lotto> lottos = new ArrayList<>();
		for (String manual : manualLottoInput) {
			lottos.add(createManual(manual));
		}
		for (int i = 0; i < autoLottoCount; i++) {
			lottos.add(createAuto());
		}
		return new Lottos(lottos);
	}
}
