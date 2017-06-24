   /* 
    
    class Node 
       int data;
       Node left;
       Node right;
   */
List<Node> queue=new ArrayList<>();
   void LevelOrder(Node root)
    {
        queue.add(root);
        queue.add(null);
        System.out.println("Next Siblings of every Node is : ");
        while(queue.size()!=0){
            if(queue.get(0)==null){
                if(queue.size()==1)
                    break;
                System.out.println();
                queue.remove(0);
                queue.add(null);
                continue;
            }
            Node t=queue.get(0);
            queue.remove(0);
            System.out.print(t.data+" - "+((queue.get(0)==null)?"null":queue.get(0).data)+ " , ");
            if(t.left!=null)
                queue.add(t.left);
            if(t.right!=null)
                queue.add(t.right);
        }
    }
/*
Input ::
Level 1:        3
              /   \
Level 2:     5     2
            / \    /
Level 3:   1   4  6

Output ::
Next Siblings of every Node is : 
3 - null , 
5 - 2 , 2 - null , 
1 - 4 , 4 - 6 , 6 - null ,
*/