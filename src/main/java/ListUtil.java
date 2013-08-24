package util;

public class ListUtil {
	private static java.util.List list = new java.util.LinkedList();

	public void add(Object obj)	 {
		list.add(obj);
	}

	public long size() {
		return list.size();
	}
}