import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        MatrixUDG m=new MatrixUDG();
        int sourceIndex,aimIndex;
        Scanner scanner=new Scanner(System.in);
        sourceIndex=scanner.nextInt();
        aimIndex=scanner.nextInt();
        System.out.println(Dijkstra.DijkstraMethod(m, m.get_mVers()[sourceIndex], m.get_mVers()[aimIndex]));
        scanner.close();
    }
}
