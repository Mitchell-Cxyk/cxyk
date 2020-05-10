class FloyedMatrix{
    Integer[][] fMatrix;

}

public class FloydMethod {
    static int floydMethod(MatrixUDG m,char source,char aim){
        int num=m.get_mVers().length;
        int sourceIndex=MatrixUDGUtil.getPosition(m.get_mVers(),source);
        int aimIndex=MatrixUDGUtil.getPosition(m.get_mVers(),aim);
        Integer[][][] fMatrix=new Integer[num+1][num][num];
        fMatrix[0]=m.get_mMatrix();//初始化迭代矩阵
        for (int fIndex=0;fIndex<num;fIndex++) {
            for (int eIndex=0;eIndex<num;eIndex++) {
                for(int index=1;index<=num;index++){
                    fMatrix[index][fIndex][eIndex]=Math.min(fMatrix[index-1][fIndex][eIndex],fMatrix[index-1][fIndex][index]+fMatrix[index-1][index][eIndex]);
                }
            }
        }
        return fMatrix[num][sourceIndex][aimIndex];
    }
}
