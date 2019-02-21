package biblioteca.utilidades;

/**
 *
 * @author Guilherme R. de Carvalho
 */
public class Ordenacao {

    public static void mergesort(Object[] a, int ini, int fim) {
        if (ini < fim) {
            int meio = (ini + fim) / 2;
            mergesort(a, ini, meio);
            mergesort(a, meio + 1, fim);
            intercala(a, ini, meio, fim);
        }
    }

    public static void intercala(Object[] a, int ini, int meio, int fim) {
        Comparable[] b = new Comparable[a.length];

        for (int i = ini; i <= fim; i++) {
            if (a[i] == null) {
                a[i] = (Object) Integer.MAX_VALUE;
            }
            b[i] = (Comparable) a[i];
        }

        int i = ini,
                j = meio + 1,
                k = ini;

        while (i <= meio && j <= fim) {
            if (b[i].compareTo(b[j]) <= 0) {
                a[k++] = b[i++];
            } else {
                a[k++] = b[j++];
            }
        }

        while (i <= meio) {
            a[k++] = b[i++];
        }
    }
}
