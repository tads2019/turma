package org.eclipse.wb.swt;

import java.lang.reflect.Method;

import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerColumn;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Tree;


public class TreeViewerColumnSorter extends ViewerComparator {
	public static final int ASC = 1;
	public static final int NONE = 0;
	public static final int DESC = -1;
	

	private final TreeViewerColumn mColumn;
	private final TreeViewer mViewer;
	private final Tree mTable;
	private int mDirection = NONE;
	
	public TreeViewerColumnSorter(TreeViewerColumn column) {
		mColumn = column;
		mViewer = (TreeViewer) column.getViewer();
		mTable = mViewer.getTree();
		mColumn.getColumn().addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (mViewer.getComparator() != null) {
					if (mViewer.getComparator() == TreeViewerColumnSorter.this) {
						if (mDirection == ASC) {
							setSorter(DESC);
						} else if (mDirection == DESC) {
							setSorter(NONE);
						}
					} else {
						setSorter(ASC);
					}
				} else {
					setSorter(ASC);
				}
			}
		});
	}
	
	
	public void setSorter(int direction) {
		if (direction == NONE) {
			mTable.setSortColumn(null);
			mTable.setSortDirection(SWT.NONE);
			mViewer.setComparator(null);
		} else {
			mTable.setSortColumn(mColumn.getColumn());
			mDirection = direction;
			if (mDirection == ASC) {
				mTable.setSortDirection(SWT.DOWN);
			} else {
				mTable.setSortDirection(SWT.UP);
			}
			if (mViewer.getComparator() == this) {
				mViewer.refresh();
			} else {
				mViewer.setComparator(this);
			}
		}
	}

	
	@Override
	public int compare(Viewer viewer, Object e1, Object e2) {
		return mDirection * doCompare(e1, e2);
	}
	
	/**
	 * Compares to elements of viewer. By default tries to compare values extracted from these elements using
	 * {@link #getValue(Object)}, because usually you want to compare value of some attribute.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected int doCompare(Object e1, Object e2) {
		Object o1 = getValue(e1);
		Object o2 = getValue(e2);
		
		if(o1 == null || o2 == null)
			return 0;
		
		if (o1 instanceof Comparable && o2 instanceof Comparable)
			return ((Comparable) o1).compareTo(o2);
		
		return 0;
	}
	
	/**
	 * 
	 * @return the value to compare in {@link #doCompare(Viewer, Object, Object)}. Be default tries to get it
	 *         from {@link EditingSupport}. May return <code>null</code>.
	 */
	protected Object getValue(Object o) {
		try {
			EditingSupport editingSupport;
			{
				Method getEditingMethod = ViewerColumn.class.getDeclaredMethod("getEditingSupport", new Class[]{});
				getEditingMethod.setAccessible(true);
				editingSupport = (EditingSupport) getEditingMethod.invoke(mColumn, new Object[]{});
			}
			if (editingSupport != null) {
				Method getValueMethod = EditingSupport.class.getDeclaredMethod("getValue", new Class[]{Object.class});
				getValueMethod.setAccessible(true);
				return getValueMethod.invoke(editingSupport, new Object[]{o});
			}
		} catch (Throwable e) {
		}
		return null;
	}
}

