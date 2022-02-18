import java.time.LocalDate;

public class Transactions {
    private String typeAccount;
    private String numberAccount;
    private String currency;
    private LocalDate date;
    private String reference;
    private String operationInfo;
    private String incomeAndExpense;

    public Transactions(String typeAccount, String numberAccount, String currency,
                        LocalDate date, String reference, String operationInfo,
                        String income) {
        this.typeAccount = typeAccount;
        this.numberAccount = numberAccount;
        this.currency = currency;
        this.date = date;
        this.reference = reference;
        this.operationInfo = operationInfo;
        this.incomeAndExpense = income;
    }

    @Override
    public String toString() {
        return String.format("%s - %s - %s - %td.%tm.%ty - %s - %s - %s", typeAccount, numberAccount,
                currency, date, date, date, reference, operationInfo, incomeAndExpense);
    }

    public String getTypeAccount() {
        return typeAccount;
    }

    public void setTypeAccount(String typeAccount) {
        this.typeAccount = typeAccount;
    }

    public String getNumberAccount() {
        return numberAccount;
    }

    public void setNumberAccount(String numberAccount) {
        this.numberAccount = numberAccount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getOperationInfo() {
        return operationInfo;
    }

    public void setOperationInfo(String operationInfo) {
        this.operationInfo = operationInfo;
    }

    public double getIncomeAndExpense() {
        char firstIndex = incomeAndExpense.charAt(0);

        if (firstIndex == '0') {
            String expense = incomeAndExpense.replace("\"", "").replace(",", ".");
            expense = expense.substring(incomeAndExpense.indexOf(',') + 1);
            return -Double.parseDouble(expense);
        } else {
            String income = incomeAndExpense.replace("\"", "").replace(",", ".");
            income = income.substring(0, income.lastIndexOf('.'));
            return Double.parseDouble(income);
        }
    }

    public void setIncomeAndExpense(String incomeAndExpense) {
        this.incomeAndExpense = incomeAndExpense;
    }


}