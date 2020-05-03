import java.util.Scanner;
/**
 * prim算法实现最小生成树
 */
public class MatrixUDG {
    private char[] mVers;    //顶点集合
    private Integer[][] mMatrix;  //邻接矩阵
    private static final int INF=Integer.MAX_VALUE;

    public MatrixUDG (){
        /**
         * 无参构造函数，需要写入
         */
        Scanner scanner=new Scanner(System.in);
        System.out.print("please enter the vertex number:");
        int lenOfVer=scanner.nextInt();
        System.out.print("please enter the edge number:");
        int lenOfEdge=scanner.nextInt();
        //check the input
        if(lenOfVer<1||lenOfEdge<1||lenOfEdge>lenOfVer*(lenOfVer-1)){
            System.out.println("非法简单图");
            scanner.close();
        }
        //input the vertex
        mVers=new char[lenOfVer];
        for(int i=0;i<lenOfVer;i++){
            char temp=scanner.next().charAt(0);
            mVers[i]=temp;
        }
        //初始化对角线
        mMatrix=new Integer[lenOfVer][lenOfVer];
        for(int i=0;i<lenOfVer;i++){
            for(int j=0;j<lenOfVer;j++){
                if(i==j){
                    mMatrix[i][j]=0;//初始化对角线为零
                }
                else{
                    mMatrix[i][j]=INF;
                    //初始化其他为整数对象的最大值,即无穷大，意味着不相邻即下面未处理者
                }
            }
        }
        //初始化权值
        for(int i=0;i<lenOfEdge;i++){//用户将边一次次输入，输入格式：起点，终点，权重
            System.out.print("请输入第"+(i+1)+"条边的信息，格式：起点顶点，终点顶点，权重；");
            char v1=scanner.next().charAt(0);
            char v2=scanner.next().charAt(0);
            Integer weight=scanner.nextInt();
            MatrixUDGUtil getPositionUtil=new MatrixUDGUtil(mVers);
            Integer p1=getPositionUtil.getPosition(v1);
            Integer p2=getPositionUtil.getPosition(v2);
            if(p1==-1||p2==-1){
                System.out.println("Wrong Input!");
                return ;
            }
            //这里只考虑无向图，有向图不一样就可以了
            mMatrix[p1][p2]=weight;
            mMatrix[p2][p1]=weight;
        }
        scanner.close();
    }
    /**
     * 用两个字段来构造
     */

    public MatrixUDG(char[] mVers, Integer[][] mMatrix) {
        this.mVers = mVers;
        this.mMatrix = mMatrix;
    }
    /**
     * primMethod
     * start为开始的那个的下标
     */
    public void primMethod(char[] mVers,Integer[][] mMatrix,Integer start){
        this.mMatrix=mMatrix;
        this.mVers=mVers;
        int num=mVers.length;
        char[] storePrims=new char[num];//储存最小生成树的数组
        int[] storeWeight=new int[num];
        int[] nearWeight=new int[num];
        int temp=0;
        storePrims[temp]=mVers[start];//把开始的下标储存到数组里
        storeWeight[0]=0;//到第一个顶点的边的长度定义为0，由于确定了start，这个并不重要
        temp++;//temp=1
        for(int i=0;i<num;i++){
            nearWeight[i]=mMatrix[start][i];
            //把start的相邻边权重储存到数组里，第i个是它到第i个顶点的距离，这里面包含了
            //自己与不相邻点
        }
        for(int i=0;i<num;i++){
            if(i==start){
                continue;//跳过start
            }
            int j=0;//遍历所有未添加的节点
            int k=0;//储存每次比min还小的边对应的顶点
            int min=INF;
            //找相邻边里权值最小的边
            for(;j<num;j++){
                //未加入最小生成树的点，凡是加入的权值都是0
                if(nearWeight[j]!=0&&min>nearWeight[j]){
                    min=nearWeight[j];
                    k=j;
                }
            }
            //把第k个节点加入最小生成树中,同时把到第k个节点的边的权重记在storeWeight中，
            //这样就唯一确定了U与其余的连接的边
            storePrims[temp]=mVers[k];
            storeWeight[temp]=min;
            temp++;   //更新指着最小生成树尾的标志
            nearWeight[k]=0;
            /**更新nearWeight，事实上就是凡是加入最小生成树的节点相邻的边都不动（为0），
            *再考虑与k（刚添加的节点）相邻的边，这时原来的nearWeight里储存的是之前与每个
            *节点的边的权重最小的值，由于从第一个开始，类似数学归纳法，如果新的k与目标节
            *点的边的权重比nearWeight里储存的还要小，就更新nearWeight，这样得到的就是集
            *合U与剩余部分的最短边长，选出最小的，就是下一个要添加的节点 
            */
            for(j=0;j<num;j++){
                if(nearWeight[j]!=0&&mMatrix[k][j]<nearWeight[j]){
                   nearWeight[j]=mMatrix[k][j];
                }
            }
        }
        /**
         * 输出手段略，事实上可以通过storePrims与storeWeight两个数组，来不断查询
         * 修改mMatrix，让其余的都变成INF，形成一个邻接矩阵，实际上代表的是一颗树
         * 的邻接矩阵。这样可以返回一个图对象，只要改一下，把函数void类型改成MatrixUDG
         * 类型就可以。
         */

    }
}