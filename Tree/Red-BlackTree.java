//Red Black tree insertion........

class Node{
	int data;
	Node left,right;
	char color;
}
//root,prnt=null
Node redBlack(Node root,Node prnt,int n){
	if(root==null){
		Node t=new Node(n);
		if(prnt==null){
			t.color='B';
		}else{
			t.color='R';
		}
		return t;
	}
	Node t1=null,sbl=null;
	if(root.data>=n){
		root.left=redBlack(root.left,root,n);
		t1=root.left;
		sbl=prnt.right;
	}else{
		root.right=redBlack(root.right,root,n);
		t1=root.right;
		sbl=root.left;
	}
	if(t1.color=='R' && root.color=='B'){
		return root;
	}else if(t1.color=='R' && root.color=='R' && sbl.color=='R'){
		t1.color='B';
		sbl.color='B';
	}else if(t1.color=='R' && root.color=='R' && (sbl==null || sbl.color=='B')){
		//do rotations
		if(prnt.left==root)
			right rotations
		else
			left rotations
	}
	if(t1.color=='B' && sbl.color=='B'){
		root.color='R';
	}
	return root;
}

