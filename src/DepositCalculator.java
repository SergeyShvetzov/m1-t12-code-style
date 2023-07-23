import java.util.Scanner;

public class DepositCalculator {

    double calculateComplexPercent(double amount, int depositPeriod) {
        double pay = amount * Math.pow((1 + 0.06 / 12), 12 * depositPeriod);

        return scaleCalculation(pay);
    }

    double calculateSimplePercent(double amount, int depositPeriod) {
        return scaleCalculation(amount + amount * 0.06 * depositPeriod);
    }

    double scaleCalculation(double value) {
        double scale = Math.pow(10, 2);

        return Math.round(value * scale) / scale;
    }

    void doImportantWork() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите сумму вклада в рублях:");
            int amount = scanner.nextInt();

        System.out.println("Введите срок вклада в годах:");
            int period = scanner.nextInt();

        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
            int action = scanner.nextInt();

        double sum = 0;

        if (action == 1) {
            sum = calculateSimplePercent(amount, period);
        } else if (action == 2) {
            sum = calculateComplexPercent(amount, period);
        }
        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + sum);
    }
public static void main(String[] args) {
        new DepositCalculator().doImportantWork();
    }
}
