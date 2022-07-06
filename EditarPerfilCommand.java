import java.util.ArrayList;
import java.util.Scanner;

public class EditarPerfilCommand implements Command{
    @Override

    public void execute(Conta uTemp, ArrayList<Conta> contas, ArrayList<Palavra> palavras, ArrayList<Feed> feeds, ArrayList<Comunidade> comunidades){
 
        Scanner teclado = new Scanner(System.in);
        System.out.println("\nQue informacao voce quer editar?\n[1]NOME\n[2]LOGIN\n[3]SENHA\n[-1]SAIR\n");                       
        int e = teclado.nextInt();
        teclado.nextLine();
                                 
        switch(e){
                case 1:
            
                    while(true){
                                                        
                        System.out.print("Digite seu novo nome: ");
                        String x = teclado.nextLine();
            
                        boolean isNumeric = x.chars().allMatch( Character::isDigit );
                                
                        if (isNumeric || x.equals(uTemp.getNome())) {
                            System.out.println("\n(!) Seu nome nao pode ser somente numeros e não pode ser igual ao primeiro.\n");
                            continue;
                        } else {
                            uTemp.setNome(x);
                            break;
                        }
                    }
                
                    System.out.print("\nNome alterado com sucesso.\n");
                break;

                case 2:
                                                    
                    while(true){
                
                        System.out.print("Digite seu novo login: ");
                        String y = teclado.nextLine();
                
                        if (y.contains("@") && y.contains(".") && (!y.equals(uTemp.getLogin()))) {
                            uTemp.setLogin(y);
                            break;
                        } else {
                            System.out.println("\n(!) Seu login deve ser um email valido e nao pode ser igual ao ultimo.\n");
                            continue;
                        }
                    }
                    
                    System.out.print("\nLogin alterado com sucesso.\n");
                break;
        
                case 3:
            
                    while(true){
            
                        System.out.print("Digite sua nova senha: ");
                        String zz = teclado.nextLine();
            
                        if((zz.contains("@") || zz.contains("#") || zz.contains("$") || zz.contains("%") || zz.contains("&") || zz.contains("*"))){
                                                            
                            if ((zz.contains("1") || zz.contains("2") || zz.contains("3") || zz.contains("4") || zz.contains("5") || zz.contains("6") || zz.contains("7") || zz.contains("8") || zz.contains("9"))) {
                                                                
                                if (!zz.equals(uTemp.getSenha())) {
                                    uTemp.setSenha(zz);
                                    break;
                                } else {
                                    System.out.println("\n(!) Sua senha deve conter no minimo 1 numero, 1 caractere especial (@, #, $, %, &, *) e nao pode ser igual a ultima.\n");
                                }
            
                            } else {
                                System.out.println("\n(!) Sua senha deve conter no minimo 1 numero, 1 caractere especial (@, #, $, %, &, *) e nao pode ser igual a ultima.\n");
                            }
                                
                        }else{
                            System.out.println("\n(!) Sua senha deve conter no minimo 1 numero, 1 caractere especial (@, #, $, %, &, *) e nao pode ser igual a ultima.\n");
                        }
                    }
                                                    
                    System.out.print("\nSenha alterada com sucesso\n");
                break;
                                        
                case -1:
                    System.out.println("Processo cancelado");
                break;
                                                
                default: 
                    System.out.println("Nenhuma das opcoes foi escolhida.");
                break; 
                                        
    }
}
}
