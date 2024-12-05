import java.util.Arrays;

public class OptimizedPermutations {

    // Generates all permutations but skips equivalent classes
    static void permutations(int v[]) {
        boolean used[] = new boolean[v.length]; // Element usage tracker
        int perm[] = new int[v.length];         // Current permutation
        for (int i = 0; i < v.length; i++) {
            perm[i] = i;
        }
        goPerm(0, v, used, perm); // Call the recursive function
    }

    // Recursive function to generate unique permutations
    static void goPerm(int cur, int v[], boolean used[], int perm[]) {
        if (cur == v.length) {  // Base case: completed a permutation
            if (isCanonical(perm, v.length)) {
                // Process the permutation only if it's the canonical form
                for (int i = 0; i < perm.length; i++) {
                    System.out.print(perm[i] + " ");
                }
                System.out.print("----");
                for (int i = 0; i < v.length; i++) { // Print the permutation
                    System.out.print(v[perm[i]] + " ");
                }
                System.out.println();
            }
        } else { // Recursive case: continue generating
            for (int i = 0; i < v.length; i++) { // Try all elements
                if (!used[i]) {
                    used[i] = true;
                    perm[cur] = i;
                    goPerm(cur + 1, v, used, perm);
                    used[i] = false;
                }
            }
        }
    }

    // Check if a permutation is canonical (smallest rotation and reversal)
    static boolean isCanonical(int perm[], int n) {
        // Convert permutation to array representation
        int[] forward = Arrays.copyOf(perm, n);
        int[] reverse = new int[n];
        for (int i = 0; i < n; i++) {
            reverse[i] = perm[n - 1 - i];
        }

        // Compare with all rotations of both forward and reverse
        for (int i = 1; i < n; i++) {
            if (compareRotations(forward, rotate(forward, i)) > 0 ||
                compareRotations(forward, rotate(reverse, i)) > 0) {
                return false;
            }
        }
        return true;
    }

    // Rotate an array by `shift` positions
    static int[] rotate(int[] array, int shift) {
        int n = array.length;
        int[] rotated = new int[n];
        for (int i = 0; i < n; i++) {
            rotated[i] = array[(i + shift) % n];
        }
        return rotated;
    }

    // Compare two arrays lexicographically
    static int compareRotations(int[] a, int[] b) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                return a[i] - b[i];
            }
        }
        return 0; // Arrays are equal
    }

    // Example usage
    public static void main(String[] args) {
        int v[] = {0, 1, 2, 3,4,5,6};
        permutations(v);
    }
}
