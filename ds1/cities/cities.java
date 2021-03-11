package cities;

import java.util.Scanner;



public class cities
{
    public int uf;
    public String nome, pop;
    private boolean systemValue;
    private static Scanner scan = new Scanner(System.in);

    //Metodo construtor para ser usado no codigo.
    public cities(String nome,int uf,String pop)
    {
        this.uf = uf;
        this.pop = pop;
        this.nome = nome;
        this.systemValue = true;
    }

    //Metodo construtor para quando o usuario criar um novo objeto dessa classe.
    public cities()
    {
        this.systemValue = false;
        System.out.println("\n.\nInsira o nome da cidade: ");
        this.nome = setName();
        System.out.println("\n.\nInsira a UF da cidade: ");
        this.uf = scan.nextInt();
        System.out.println("\n.\nInsira a populacao da cidade:");
        this.pop = scan.next();
        System.out.println("\n.\n-Cidade pronta!-");
    }

    //Pede o nome ao usuario e checa se esta correto.
    private String setName()
    {
        String a = scan.next();//Lê um input do usuario.
        
        char[] b = a.toCharArray();//Transforma a string em um array de chars.
        
        if(a == null||a.isEmpty())//Checa se a string esta vazia.
        {
            System.out.println("\n.\nNome invalido, tente novamente.");
            a = setName();
        }else{
            for(int i = 0; i > b.length; i++)
            {
                
                if(!Character.isLetter(b[i]))//Checa se o char nao e uma letra.
                {
                    //Checa se o char e os adjacentes estao vazios.
                    if(Character.isWhitespace(b[i]) &&(Character.isWhitespace(b[i-1])||Character.isWhitespace(b[i+1])))
                    {
                        System.out.println("\n.\nNome invalido, tente novamente.");
                        a = setName();
                        break;
                    }else if(!Character.isWhitespace(b[i])) //Se o char nao for letra ou espaco, esse if e executado.
                    {
                        System.out.println("\n.\nNome invalido, tente novamente.");
                        a = setName();
                        break;
                    }
                }
            }
        }
        return a;
    }

    public String GetName()
    {
        return this.nome;
    }

    public void printElements() //Escreve as informacoes da cidade selecionada.
    {
        System.out.println(String.format("Cidade: %s\nUF: %d\nPopulacao: %s.",this.nome,this.uf,this.pop));
    }

    public void PrintTabela(int i)
    {
        System.out.println(String.format(" %d | %d | %s | %s", i, this.uf, this.nome, this.pop));
    }
}