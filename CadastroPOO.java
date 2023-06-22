package cadastropoo;

import model.PessoaFisica;
import model.PessoaFisicaRepo;
import model.PessoaJuridica;
import model.PessoaJuridicaRepo;

public class Main {
    
    public static void main(String[] args) {
        // Testando repositório de pessoas físicas
        PessoaFisicaRepo repo1 = new PessoaFisicaRepo();

        // Adicionando duas pessoas físicas
        PessoaFisica pf1 = new PessoaFisica(1, "João", "12345678900", 30);
        PessoaFisica pf2 = new PessoaFisica(2, "Maria", "98765432100", 25);
        repo1.inserir(pf1);
        repo1.inserir(pf2);

        try {
            // Persistindo os dados
            repo1.persistir("pessoas_fisicas.dat");

            // Recuperando os dados
            PessoaFisicaRepo repo2 = new PessoaFisicaRepo();
            repo2.recuperar("pessoas_fisicas.dat");

            // Exibindo os dados das pessoas físicas recuperadas
            System.out.println("Pessoas físicas recuperadas:");
            for (PessoaFisica pf : repo2.obterTodos()) {
                pf.exibir();
                System.out.println();
            }
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }

        System.out.println("-----------------------------");

        // Testando repositório de pessoas jurídicas
        PessoaJuridicaRepo repo3 = new PessoaJuridicaRepo();

        // Adicionando duas pessoas jurídicas
        PessoaJuridica pj1 = new PessoaJuridica(1, "Empresa1", "12345678900001");
        PessoaJuridica pj2 = new PessoaJuridica(2, "Empresa2", "98765432100001");
        repo3.inserir(pj1);
        repo3.inserir(pj2);

        try {
            // Persistindo os dados
            repo3.persistir("pessoas_juridicas.dat");

            // Recuperando os dados
            PessoaJuridicaRepo repo4 = new PessoaJuridicaRepo();
            repo4.recuperar("pessoas_juridicas.dat");

            // Exibindo os dados das pessoas jurídicas recuperadas
            System.out.println("Pessoas jurídicas recuperadas:");
            for (PessoaJuridica pj : repo4.obterTodos()) {
                pj.exibir();
                System.out.println();
            }
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
