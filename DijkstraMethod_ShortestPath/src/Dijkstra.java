import java.util.Vector;
class MinNode{
    public Integer min;
    public Vector<Integer> Path;
    public MinNode(){
        min=Integer.MAX_VALUE;
        Path=new Vector<Integer>();
    }
}
public class Dijkstra {
    static String DijkstraMethod(MatrixUDG m,char source,char aim){
        int numOfmVers=m.get_mVers().length;
        MinNode[] minPath=new MinNode[numOfmVers];//这里构造函数已经附带初始化了
        
        //初始化每个点的标记为无穷大
        /*for(int i=0;i<numOfmVers;i++){
            minPath[i].min=Integer.MAX_VALUE;
            minPath[i].Path=
        }
        */
        int sourceIndex=MatrixUDGUtil.Contains(m.get_mVers(), source);
        int aimIndex=MatrixUDGUtil.Contains(m.get_mVers(),aim);
        if(sourceIndex==-1||aimIndex==-1){
            return "Source or Aim is not at mVers";
        }
        else{
            //这里开始主要部分
            
            minPath[sourceIndex].min=0;
            minPath[sourceIndex].Path.add(sourceIndex);
            int index=sourceIndex;
            while(index!=MatrixUDGUtil.Contains(m.get_mVers(), aim)){//index走到aim的下标停止
                Vector<Integer> storeNearVertex=MatrixUDGUtil.findNearVertex(m.get_mVers(),m.get_mMatrix(),index);
                int numOfNearVertex=storeNearVertex.size();
                int storeNearVertexArray[]=new int[numOfNearVertex];
                //把vector转换成数组，感觉数组应该使用起来最快
                for(int i=0;i<numOfNearVertex;i++){
                    storeNearVertexArray[i]=storeNearVertex.get(i);
                    //如果邻接节点的标记最小值比从当前点走出来的还大，就更新minPath
                    if(minPath[index].min+m.get_mMatrix()[index][storeNearVertexArray[i]]<minPath[storeNearVertexArray[i]].min){
                        //更新min
                        minPath[storeNearVertexArray[i]].min=minPath[index].min+m.get_mMatrix()[index][storeNearVertexArray[i]];
                        //更新Path，不把点加入，只是修改为“待加入”状态
                        minPath[storeNearVertexArray[i]].Path=minPath[index].Path;
                        //minPath[storeNearVertexArray[i]].Path.add(storeNearVertexArray[i]);后来要做的，这里删除
                    }
                }
                //所有节点全部更新完毕后，找到最小min的，加入,具体操作为临时把当前的minPath.min改成无穷大，比较后再改回来，这样
                    //就找到了其他点中min最小的那个，之后进行“待加入”变为加入的过程
                    int temp=minPath[index].min;
                    minPath[index].min=Integer.MAX_VALUE;
                    int newIndex=MatrixUDGUtil.findMinInArray(minPath);
                    minPath[index].min=temp;//终于改回来了
                    index=newIndex;//更新当前点
                    minPath[index].Path.add(index);//完成加入过程
            }
            //这里index变成了aim所在的下标，如果无限循环就说明根本到不了aim，这种情况可以加一个事先的判定这两个点是否连通。既然
            //成功到了这儿，minPath[index].Path这个vector就是路径。
            return minPath[index].Path.toString();
        }

    }
}