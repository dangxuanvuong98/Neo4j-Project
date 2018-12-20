package test;

public class test {
	public static void main(String[] str) {
		child1.setIndex(1);
		System.out.println(Integer.toString(child1.getIndex()) + ' ' + Integer.toString(child2.getIndex()));
		child2.setIndex(10);
		System.out.println(Integer.toString(child1.getIndex()) + ' ' + Integer.toString(child2.getIndex()));
		parrent.setIndex(11);
		System.out.println(Integer.toString(child1.getIndex()) + ' ' + Integer.toString(child2.getIndex()));
	}
}
