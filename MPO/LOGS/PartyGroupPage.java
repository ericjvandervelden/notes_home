/*
 *
 *  * Copyright 2000-2015, MP Objects, http://www.mp-objects.com
 *
 *   */

package com.mpobjects.oms.view.wicket.partygroup;



import java.util.List;



import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;

import org.apache.wicket.model.IModel;

import org.apache.wicket.model.Model;

import org.apache.wicket.model.ResourceModel;

import org.apache.wicket.model.StringResourceModel;



import com.mpobjects.oms.model.partygroup.dao.PartyGroupDAO;

import com.mpobjects.oms.model.partygroup.vo.PartyGroupVO;

import com.mpobjects.oms.view.wicket.enumeratedvo.EvoEditFormPage;

import com.mpobjects.oms.view.wicket.enumeratedvo.EvoEditPage;

import com.mpobjects.oms.view.wicket.enumeratedvo.EvoListPage;

import com.mpobjects.oms.view.wicket.enumeratedvo.EvoSearchListPanel;

import com.mpobjects.util.dao.EnumeratedValueObjectDAOInterface;

import com.mpobjects.view.wicket.util.BeanWrapper;

import com.mpobjects.view.wicket.util.Privilege;

import com.mpobjects.view.wicket.util.multi.ConfigurableTextFilteredPropertyColumn;



@Privilege(object = "party-group", type = "edit")

public class PartyGroupPage extends EvoEditPage<PartyGroupVO> {



	protected static final String ORGANIZATION = "organization";



	public PartyGroupPage() {

		super();

		usePopupEdit = false;

	}



	@Override

	protected void createListPanel() {

		searchListPanel = new EvoSearchListPanel<PartyGroupVO>("evoSearchList", null, webComponentEventSwitchBoard, daoWrapper, getListActions()) {

			private static final long serialVersionUID = 1L;



			@Override

			protected void addFilterColumns(List<IColumn> columnList) {

				super.addFilterColumns(columnList);

				columnList.add(new ConfigurableTextFilteredPropertyColumn<String>(new ResourceModel(ORGANIZATION), ORGANIZATION, ORGANIZATION + ".code",

						new ConfigurableTextFilteredPropertyColumn.FilterTextfieldBuilder<String>(10)));

			}

		};

		searchListPanel.setDataProperties(dataProperties);

		final IModel<String> editPageTitle = new StringResourceModel("listTitle", PartyGroupPage.this,

				new Model<EvoListPage<PartyGroupVO>>(PartyGroupPage.this), "Search ${entityName}");

		searchListPanel.setTitle(editPageTitle.getObject());

		searchListPanel.setOutputMarkupId(true);

		add(searchListPanel);

	}



	@Override

	protected BeanWrapper<? extends EnumeratedValueObjectDAOInterface<PartyGroupVO>> getBeanWrapper() {

		return new BeanWrapper<PartyGroupDAO>(PartyGroupDAO.class);

	}



	@Override

	protected EvoEditFormPage<PartyGroupVO> getEditPage() {

		if (editPage == null) {

			editPage = new PartyGroupEditFormPage(this, daoWrapper, dataProperties);

		}

		return editPage;

	}



	@Override

	protected void setDataProperties() {

		super.setDataProperties();

		dataProperties.setCancelConfirm(true);

		PartyGroupDataProperties.setDefaults(dataProperties);

	}



	@Override

	protected boolean mayDeleteObject(PartyGroupVO aObject) {

		return false;

	}

}


