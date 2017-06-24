   /* 
    
    class Node 
       int data;
       Node left;
       Node right;
   */
List<Node> stack1=new ArrayList<>();
List<Node> stack2=new ArrayList<>();
   void LevelOrder(Node root)
    {
       int i=1;
       stack1.add(root);
       while(stack1.size()!=0 || stack2.size()!=0){
           if(i%2==0){
               //System.out.print(stack2.size()+" d ");
               while(stack2.size()!=0){
                   Node t=stack2.get(stack2.size()-1);
                   System.out.print(t.data+" ");
                   stack2.remove(stack2.size()-1);
                   if(t.left!=null)
                        stack1.add(t.left);
                   if(t.right!=null)
                        stack1.add(t.right);
               }
               i++;
           }else{
               while(stack1.size()!=0){
                   Node t=stack1.get(stack1.size()-1);
                   stack1.remove(stack1.size()-1);
                   System.out.print(t.data+" ");
                   if(t.right!=null)
                        stack2.add(t.right);
                   if(t.left!=null)
                        stack2.add(t.left);
               }
               i++;
           }
           //System.out.print(stack1.size()+" : "+stack2.size());
       }
       
    }
/*
Input ::

Level 1:        3
              /   \
Level 2:     5     2
            / \    /
Level 3:   1   4  6
OutPut ::
3 5 2 6 4 1 
*/