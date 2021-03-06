package lotto.domain.controller;

import java.util.List;

import lotto.domain.Lotto;
import lotto.domain.LottoCount;
import lotto.domain.LottoFactory;
import lotto.domain.Lottos;
import lotto.domain.Number;
import lotto.domain.PurchaseMoney;
import lotto.domain.WinningLotto;
import lotto.domain.result.GameResult;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
	public void run() {
		PurchaseMoney money = new PurchaseMoney(InputView.getMoney());
		LottoCount count = new LottoCount(InputView.getManualCount(), money.parseToPiece());
		List<String> manualLottoInput = InputView.getManualLottos(count.getManualLotto());
		Lottos lottos = LottoFactory.createManualsAndAutos(manualLottoInput, count.getAutoLotto());
		OutputView.printPieces(count);
		OutputView.printLottos(lottos);
		GameResult result = createResult(lottos, createWinningLotto());
		OutputView.printResult(result);
		OutputView.printProfit(result.getEarningMoney(money));
	}

	private WinningLotto createWinningLotto() {
		Lotto winningNumbers = LottoFactory.createManual(InputView.getWinningNumbers());
		Number bonusNumber = Number.of(InputView.getBonusNumber());
		return new WinningLotto(winningNumbers, bonusNumber);
	}

	private GameResult createResult(Lottos lottos, WinningLotto winningLotto) {
		return new GameResult(winningLotto, lottos);
	}
}
