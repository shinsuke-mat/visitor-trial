package visitor.trial;

import java.util.ArrayList;
import java.util.List;

public abstract class Node {
	List<Node> children = new ArrayList<>();

	// 子の追加
	public void addChild(Node child) {
		children.add(child);
	}

	public abstract void accept0(Visitor visitor);
	
	// 再帰的なvisit & accept
	public void accept(Visitor visitor) {
		
		// ここでのthisは間違いなく子クラスになっている
		// 以下で確認可能
		// System.err.println(this.getClass().getName()); 
		visitor.visit(this);
		for (Node child : children) {
			child.accept0(visitor);
		}
	}
}
