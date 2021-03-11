package cities;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

class main
{
    static ArrayList<cities> citiesList = new ArrayList<cities>(); //Lista de cidades.
    private static Scanner scan = new Scanner(System.in);
    private static boolean running = true;

    public static void main(String[] args) //Metodo principal.
    {
        SetSystemCities();
        PrintTabela();

        while (running)
        {
            Selection();
            System.out.println("-----------------------------------------------------------------------");
        }

        EndProgram();
    }

    public static void SetSystemCities() //Cria cidades predefinidas.
    {
        citiesList.add(new cities("Sao Paulo",35,"12.2 milhoes"));
        citiesList.add(new cities("Rio de Janeiro",33,"6.7 milhoes"));
        citiesList.add(new cities("Brasilia",53,"3 milhoes"));
        citiesList.add(new cities("Salvador",29,"2.8 milhoes"));
        citiesList.add(new cities("Belo Horizonte",31,"2.5 milhoes"));
    }

    public static void PrintTabela() //Mostra a lista de cidades.
    {
        System.out.println("\n.\n Indice | UF | Cidade | Populacao");
        for(cities c : citiesList)
        {
            c.PrintTabela(citiesList.indexOf(c));
        }
        System.out.println("\n.");
    }

    public static void Addcities() //Cria uma nova cidade.
    {
        citiesList.add(new cities());
    }

  /*  public static void DeleteAllCities() //Remove todas as cidades.
    {
        for(cities c : citiesList)
        {
            citiesList.remove(c);
        }
    }*/

    public static void DeleteCity() //Remove uma cidade especifica.
    {
        System.out.println("\nDigite o indice da cidade: ");
        int i = scan.nextInt();
        while(i >= citiesList.size() || i < 0)
        {
            System.out.println("\nIndice invalido, tente novamente.");
            i = scan.nextInt();
        }
        citiesList.remove(i);
    }

    public static void PrintCity() //Mostra uma cidade especifica.
    {
        System.out.println("\nComo quer achar a cidade?");
        System.out.println("1. Nome.");
        System.out.println("2. Indice.");
        System.out.println("3. Aleatoriamente.\n");
        int i = scan.nextInt();
        if(i >= 1 && i <= 3)
        {
            if(i == 1)
            {
                System.out.println("\nDigite o nome: ");
                String nome = scan.next();
                
                for(cities cn : citiesList)
                {
                    int n =  citiesList.indexOf(cn);
                    if(cn.GetName() == nome)
                    {
                       // System.out.println(String.format("\nIndice: %d\nUF: %d\nNome: %s\nPopulacao: %s", n,citiesList[n].uf,citiesList[n].nome,citiesList[n].pop));
                       System.out.println("\nIndice: ");
                       System.out.print(String.format("%d", n));
                       cn.printElements();
                    }
                }
            }else if (i == 2)
            {
                System.out.println("\nDigite o indice: ");
                int ind = scan.nextInt();
                while(ind >= citiesList.size() || ind < 0)
                {
                    System.out.println("\nIndice invalido, tente novamente.");
                    ind = scan.nextInt();
                    
                }
                //System.out.println(String.format("\nIndice: %d\nUF: %d\nNome: %s\nPopulacao: %s", ind,citiesList[ind].uf,citiesList[ind].nome,citiesList[ind].pop));
                System.out.println("\nIndice: ");
                System.out.print(String.format("%d", ind));
                citiesList.get(ind).printElements();
            }else if (i == 3)
            {
                Random r = new Random();
                int ir = r.nextInt(citiesList.size());
               //System.out.println(String.format("\nIndice: %d\nUF: %d\nNome: %s\nPopulacao: %s", ir,citiesList[ir].uf,citiesList[ir].nome,citiesList[ir].pop));
                System.out.println("\nIndice: ");
                System.out.print(String.format("%d", ir));
                citiesList.get(ir).printElements();
            }
        }

    }

    public static void Selection() //Selecao de comandos.
    {
        System.out.println("\nO que deseja fazer agora?");
        System.out.println("\n1. Adicionar cidade.");
        System.out.println("2. Remover cidade.");
        System.out.println("3. Procurar cidade.");
        System.out.println("4. Remover todas as cidades.");
        System.out.println("5. Ver lista de cidades.");
        System.out.println("6. Encerrar.\n");
        int i = scan.nextInt();

        switch(i)
        {
            case 1:
                Addcities();
                break;

            case 2:
                DeleteCity();
                break;

            case 3:
                PrintCity();
                break;

            case 4:
                //DeleteAllCities();
                citiesList.clear();
                break;

            case 5:
                PrintTabela();
                break;

            case 6:
                running = false;
                 break;

            default:
                System.out.println("Indice invalido");
        }        
    }

    public static void EndProgram() //Mensagem mostrada ao finalizar o programa.
    {
        System.out.println("\n.\n.\n.\n.\nAte Mais!");
        System.out.println("Programa por Isael.");
    }
}