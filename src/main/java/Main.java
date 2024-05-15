import java.util.*;

public class Main {

    static class StringTexto {
        String texto;

        public StringTexto(String texto) {
            this.texto = texto;
        }

        public String getTexto() {
            return texto;
        }
    }

    static void ordena(StringTexto[] palavras) {
        Arrays.sort(palavras, new Comparator<StringTexto>() {
            @Override
            public int compare(StringTexto s1, StringTexto s2) {
                int len1 = s1.getTexto().length();
                int len2 = s2.getTexto().length();

                if (len1 != len2) {
                    return Integer.compare(len2, len1); // Ordena por tamanho decrescente
                } else {
                    return 0; // Mantém a ordem original
                }
            }
        });
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int casos = scanner.nextInt();
        scanner.nextLine(); // Consumir quebra de linha

        while (casos-- > 0) {
            String entrada = scanner.nextLine();
            String[] palavrasSeparadas = entrada.split(" ");

            StringTexto[] palavras = new StringTexto[palavrasSeparadas.length];

            for (int i = 0; i < palavrasSeparadas.length; i++) {
                palavras[i] = new StringTexto(palavrasSeparadas[i]);
            }

            ordena(palavras);

            for (int i = 0; i < palavras.length; i++) {
                System.out.print(palavras[i].getTexto());
                if (i != palavras.length - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

        scanner.close();
    }
}
