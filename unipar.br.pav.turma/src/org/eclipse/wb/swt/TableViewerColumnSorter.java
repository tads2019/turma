/*******************************************************************************
 * Copyright (c) 2011 Google, Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Google, Inc. - initial API and implementation
 *******************************************************************************/
package org.eclipse.wb.swt;

import java.lang.reflect.Method;

import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerColumn;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Table;

/**
 * Helper for sorting {@link TableViewer} by one of its {@link TableViewerColumn}s.
 * <p>
 * Originally from http://wiki.eclipse.org/index.php/JFaceSnippets, Snippet040TableViewerSorting.
 * 
 * @author Tom Schindl <tom.schindl@bestsolution.at>
 * @author Konstantin Scheglov <Konstantin.Scheglov@gmail.com>
 */
public class TableViewerColumnSorter extends ViewerComparator {
	public static final int ASC = 1;
	public static final int NONE = 0;
	public static final int DESC = -1;
	////////////////////////////////////////////////////////////////////////////
	//
	// Instance fields
	//
	////////////////////////////////////////////////////////////////////////////
	private final TableViewerColumn mColumn;
	private final TableViewer mViewer;
	private final Table mTable;
	private int mDirection = NONE;
	////////////////////////////////////////////////////////////////////////////
	//
	// Constructor
	//
	////////////////////////////////////////////////////////////////////////////
	public TableViewerColumnSorter(TableViewerColumn column) {
		mColumn = column;
		mViewer = (TableViewer) column.getViewer();
		mTable = mViewer.getTable();
		mColumn.getColumn().addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (mViewer.getComparator() != null) {
					if (mViewer.getComparator() == TableViewerColumnSorter.this) {
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
	////////////////////////////////////////////////////////////////////////////
	//
	// Utils
	//
	////////////////////////////////////////////////////////////////////////////
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
	////////////////////////////////////////////////////////////////////////////
	//
	// ViewerComparator
	//
	////////////////////////////////////////////////////////////////////////////
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
		if (o1 instanceof Comparable && o2 instanceof Comparable) {
			return ((Comparable) o1).compareTo(o2);
		}
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
	
	public int getmDirection() {
		return mDirection;
	}
	public void setmDirection(int mDirection) {
		this.mDirection = mDirection;
	}
	
	/**
	 * 
	 * @param tv TableViewer que vai ser feito a ordeção
	 * @param sorter direção que está
	 * @param tvc Coluna que vai ordenar, código ou descrição
	 * @author Adler
	 */
	public void sorterTableViewer(TableViewer tv, Table table, TableViewerColumnSorter sorter, TableViewerColumn tvc){
		
		if (sorter.getmDirection() == ASC) {
			table.setSortDirection(SWT.DOWN);
		} else if(sorter.getmDirection() == DESC ) {
			table.setSortDirection(SWT.UP);
		} else {
			table.setSortDirection(NONE);
		}
		
		table.setSortColumn(tvc.getColumn());
		tv.setComparator(sorter);
		tv.refresh();
	}
	
	/**
	 ** Metodo responsavel por trocar o sentido da ordenção 
	 ** @param direcao atual da table viwer sorter
	 ** @return novo sentido de ordenação
	 ** @author Adler
	 **/
	public int getSentidoOrdencao(int direcao){
		if (direcao == NONE) {
			return ASC;
		} else if(direcao == ASC ) {
			return DESC;
		} else {
			return NONE;
		}
	}
}
