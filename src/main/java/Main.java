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

            StringTexto[] palavras = new StringTexto[60];
            String entrada = scanner.nextLine();

            int i = 0, j = 0, k = 0;
            while (true) {
                while (entrada.charAt(i) != ' ') {
                    if (entrada.charAt(i) == '\0') break;
                    else palavras[j] = new StringTexto(palavras[j].texto + entrada.charAt(i++));
                }
                palavras[j].texto += '\0';

                if (entrada.charAt(i) == '\0') break;
                i++; j++;
                k = 0;
            }

            j++;
            ordena(palavras, j);

            for (i = 0; i < j; i++) {
                if (i != j && i != 0) System.out.print(" ");
                System.out.print(palavras[i].texto);
            }
            System.out.println();
        }

        scanner.close();
    }
}
