package biblioteca.utilidades;

/**
 *
 * @author Guilherme R. de Carvalho
 */
public class Ordenacao {

    public static boolean ordena(Object[] a, int posVal) {
        if (a.length  < 2 || a == null)
            return false;

        mergesort(a, 0, posVal-1);
        return true;
    }

    private static void mergesort(Object[] a, int ini, int fim) {
        if (ini < fim) {
            int meio = (ini + fim) / 2;
            mergesort(a, ini, meio);
            mergesort(a, meio + 1, fim);
            intercala(a, ini, meio, fim);
        }
    }

    private static void intercala(Object[] a, int ini, int meio, int fim) {
        Object[] b = new Object[a.length];

        for (int i = ini; i <= fim; i++) {
            b[i] = a[i];
        }

        int i = ini,
                j = meio + 1,
                k = ini;

        while (i <= meio && j <= fim) {
            if (b[i].toString().compareTo(b[j].toString()) <= 0) {
                a[k++] = b[i++];
            } else {
                a[k++] = b[j++];
            }
        }

        while (i <= meio) {
            a[k++] = b[i++];
        }
        
        b = null;
    }
}
