public class Main {

    public static void main(String[] args) {

        BankTransaction transaction = new BankTransaction(
                1,
                "24.09.2026",
                "Банковский перевод",
                500.0,
                "EUR",
                "Ожидает",
                "Deutsche Bank",
                "DE123456789",
                "Иван Иванов"
        );

        transaction.printInfo();
        transaction.validate();
        transaction.send();
    }
}


// 1. Базовый класс
class Operation {

    private int id;
    private String date;
    private String description;

    public Operation(int id, String date, String description) {
        this.id = id;
        this.date = date;
        this.description = description;
    }

    public void start() {
        System.out.println("Операция начата.");
    }

    public void finish() {
        System.out.println("Операция завершена.");
    }

    public void printInfo() {
        System.out.println("ID: " + id);
        System.out.println("Дата: " + date);
        System.out.println("Описание: " + description);
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}


// 2. Транзакция
class Transaction extends Operation {

    private double amount;
    private String currency;
    private String status;

    public Transaction(
            int id,
            String date,
            String description,
            double amount,
            String currency,
            String status
    ) {
        super(id, date, description);
        this.amount = amount;
        this.currency = currency;
        this.status = status;
    }

    public void validate() {
        if (amount > 0) {
            System.out.println("Транзакция корректна.");
        } else {
            System.out.println("Транзакция некорректна.");
        }
    }

    public void cancel() {
        status = "Отменена";
        System.out.println("Транзакция отменена.");
    }

    public void calculate() {
        System.out.println("Сумма транзакции: " + amount + " " + currency);
    }

    // Getters
    public double getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
    }

    public String getStatus() {
        return status;
    }

    // Setters
    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}


// 3. Банковская транзакция
class BankTransaction extends Transaction {

    private String bankName;
    private String accountNumber;
    private String recipient;

    public BankTransaction(
            int id,
            String date,
            String description,
            double amount,
            String currency,
            String status,
            String bankName,
            String accountNumber,
            String recipient
    ) {
        super(id, date, description, amount, currency, status);
        this.bankName = bankName;
        this.accountNumber = accountNumber;
        this.recipient = recipient;
    }

    public void send() {
        System.out.println("Перевод отправлен.");
    }

    public void checkAccount() {
        System.out.println("Счет проверен: " + accountNumber);
    }

    public void printBankInfo() {
        System.out.println("Банк: " + bankName);
        System.out.println("Получатель: " + recipient);
    }

    @Override
    public void printInfo() {
        super.printInfo();

        System.out.println("Сумма: " + getAmount());
        System.out.println("Валюта: " + getCurrency());
        System.out.println("Статус: " + getStatus());
        System.out.println("Банк: " + bankName);
        System.out.println("Счет: " + accountNumber);
        System.out.println("Получатель: " + recipient);
    }

    // Getters
    public String getBankName() {
        return bankName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getRecipient() {
        return recipient;
    }

    // Setters
    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }
}
