import java.util.Scanner;

class Main {

    static class StringTexto {
        String texto;

        public StringTexto(String texto) {
            this.texto = texto;
        }
    }

    static void ordena(StringTexto[] palavras, int tam) {
        int i = 1, j;
        StringTexto pivo;

        while (i < tam) {
            j = i - 1;
            pivo = palavras[i];

            while (j >= 0 && palavras[j].texto.length() < pivo.texto.length()) {
                palavras[j + 1] = palavras[j];
                j--;
            }

            palavras[j + 1] = pivo;
            i++;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            int casos = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            String entrada = scanner.nextLine();
            String[] palavrasSeparadas = entrada.split(" ");

            StringTexto[] palavras = new StringTexto[palavrasSeparadas.length];

            for (int i = 0; i < palavrasSeparadas.length; i++) {
                palavras[i] = new StringTexto(palavrasSeparadas[i]);
            }

            ordena(palavras, palavras.length);

            for (int i = 0; i < palavras.length; i++) {
                if (i != palavras.length && i != 0) System.out.print(" ");
                System.out.print(palavras[i].texto);
            }
            System.out.println();
        }

        scanner.close();
    }
}
