package automacao.support;

import com.github.javafaker.Faker;

public class gerador {

    public static String  getRandomTitulo(){
        Faker faker = new Faker();
        String titulo = faker.food().fruit().toLowerCase();

        return titulo;
        
    }

    public static String  getRandomMensagem(){
        Faker faker = new Faker();
        String mensagem = faker.company().name().toLowerCase();

        return mensagem;
        
    }

    public static String  getRandomNome(){
        Faker faker = new Faker();
        String nome = faker.name().username();

        return nome;
        
    }
    
}
