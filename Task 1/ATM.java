import java.util.Scanner;

class InterfaceOfAtm{
    String name;
    String username;
    String password;
    String accountNo;
    double balance=20000;
    int transaction=0;
    String transactionHistory="";

    public void register(){
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter your name: ");
        this.name=sc.nextLine();
        System.out.println("\nEnter username : ");
        this.username=sc.nextLine();
        System.out.println("\nEnter the password : ");
        this.password=sc.nextLine();
        System.out.println("\nEnter your account number :");
        this.accountNo=sc.nextLine();
        System.out.println("\nRegistration completed successfully! Kindly login to your account");      
    }

    public boolean login(){
        boolean isLogin = false;
        Scanner sc = new Scanner(System.in);
        while (!isLogin){
            System.out.println("Enter username : ");
            String userName = sc.nextLine();
            if(userName.equals(username)){
                while (!isLogin){
                    System.out.println("\nEnter your password : ");
                    String Password = sc.nextLine();
                    if(password.equals(password)){
                        System.out.println("\nLogin successfull");
                        isLogin=true;
                    }else
                        System.out.println("\nIncorrect Password");
                }
            }else
                System.out.println("\nUsername not found");
        }
        return isLogin;
    }

    public void withdraw(){
        System.out.println("Enter the amount to be withdrawn : ");
        Scanner sc = new Scanner(System.in);
        double amount=sc.nextDouble();
        try{
            if(balance>=amount){
                balance = balance - amount;
                System.out.println("\nWithdrawal sccessfully!");
                String str="Rs" + amount + "Withdrawn\n";
                transactionHistory = transactionHistory.concat(str);
            }else
            System.out.println("\nInsuffiecient Balance");
        }catch(Exception e){
        }
    }

    public void deposit(){
        System.out.println("\nEnter amount to deposit : ");
        Scanner sc = new Scanner(System.in);
        double amount=sc.nextDouble();
        try{
            if(amount<=100000.00){
                transaction++;
                balance = balance + amount;
                System.out.println("\nDeposit successfully");
                String str = "Rs" + amount + "deposited\n";
                transactionHistory=transactionHistory.concat(str);
            }else
            System.out.println("\nLimit Exceeded!");
        }catch(Exception e){
        }
    }

    public void transfer(){
        Scanner sc = new Scanner(System.in);
        System.out.println("\nEnter recepient name : ");
        String receptient = sc.nextLine();
        System.out.println("Enter amount to be transferred : ");
        double amount = sc.nextDouble();
        try{
            if(balance >= amount){
                if(amount <=50000.00){
                    transaction++;
                    balance = balance - amount;
                    System.out.println("\nSuccessfully transferred to " + receptient);
                    String str = "Rs" + amount + "transferred to " + receptient +"\n";
                    transactionHistory = transactionHistory.concat(str);
                }else
                System.out.println("\nSorry! Limit is 50000.00");
            }else
            System.out.println("\nInsuffient balance.");
        }catch(Exception e){
        }
    }

    public void checkBalance(){
        System.out.println("\nRs " + balance);
    }

    public void transacHistory(){
        if(transaction == 0)
        System.out.println("\nEmpty!");
        else
        System.out.println("\n" + transactionHistory);
    }
}


class ATM{
    public static int takeInput(int lmt) {
        int input = 0;
        boolean flag = false;
        while(!flag){
            try{
                Scanner sc = new Scanner(System.in);
                input = sc.nextInt();
                flag = true;
                if(flag && input > lmt || input < 1){
                    System.out.println("Select number between 1 to " + lmt);
                    flag = false;
                }
            }catch(Exception e){
                System.out.println("Enter integer value only");
                flag= false;
            }
        }
        return input;
    }

    public static void main(String[] args) {
        System.out.println("\n     Welcome to SAB Bank      \n");
        System.out.println("1.Register\n2.Exit");
        System.out.println("Enter Your Choice : ");
        int choice = takeInput(2);
        if(choice == 1){
            InterfaceOfAtm b = new InterfaceOfAtm();
            b.register();
            while(true){
                System.out.println("\n1.Login\n2.Exit");
                System.out.println("Enter your choice : ");
                int ch = takeInput(2);
                if(ch==1){
                    if(b.login()){
                        System.out.println("\n\nWELCOME BACK! " + b.name + "\n\n");
                        boolean isFinished = false;
                        while(!isFinished){
                            System.out.println(
                                "\n1.Deposit\n2.Withdrawn\n3.Transfer\n4.Transaction History\n5.Check Balance");
                            System.out.println("Enter Your Choice : ");
                            int c = takeInput(6);
                            switch(c){
                                case 1:
                                    b.deposit();
                                    break;
                                case 2:
                                    b.withdraw();
                                    break;
                                case 3:
                                    b.transfer();
                                    break;
                                case 4:
                                    b.transacHistory();
                                    break;
                                case 5:
                                    b.checkBalance();
                                    break;
                                case 6:
                                    isFinished = true;
                                    break;
                                default:
                                System.out.println("\nWrong choice!");
                            }
                        }
                    }
                }else
                    System.exit(0);
            }
        }
    };
}