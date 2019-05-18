/*
 *
 *  * Copyright 2000-2015, MP Objects, http://www.mp-objects.com
 *
 *   */

package com.mpobjects.oms.view.wicket.partytypegroup;



import com.mpobjects.oms.model.partytypegroup.dao.PartyTypeGroupDAO;

import com.mpobjects.oms.model.partytypegroup.vo.PartyTypeGroupVO;

import com.mpobjects.oms.view.wicket.enumeratedvo.EvoEditFormPage;

import com.mpobjects.oms.view.wicket.enumeratedvo.EvoEditPage;

import com.mpobjects.view.wicket.util.BeanWrapper;



/**
 *
 *  * PartyTypeGroup configuration page.
 *
 *   */

public class PartyTypeGroupPage extends EvoEditPage<PartyTypeGroupVO> {

	public PartyTypeGroupPage() {

		super();

		useAjax = false;

	}



	@Override

	protected boolean mayDeleteObject(PartyTypeGroupVO aObject) {

		return false;

	}



	/*
 *
 * 	 * (non-Javadoc)
 *
 * 	 	 * 
 *
 * 	 	 	 * @see com.mpobjects.oms.view.wicket.evo.EvoSelectPage#getBeanWrapper()
 *
 * 	 	 	 	 */

	@Override

	protected BeanWrapper<PartyTypeGroupDAO> getBeanWrapper() {

		return new BeanWrapper<PartyTypeGroupDAO>(PartyTypeGroupDAO.class);

	}



	@Override

	protected EvoEditFormPage<PartyTypeGroupVO> getEditPage() {

		if (editPage == null) {

			editPage = new PartyTypeGroupEditFormPage(this, daoWrapper, dataProperties);

		}

		return editPage;

	}



	/*
 *
 * 	 * (non-Javadoc)
 *
 * 	 	 * 
 *
 * 	 	 	 * @see com.mpobjects.oms.view.wicket.enumeratedvo.EvoSelectPage#setDataProperties()
 *
 * 	 	 	 	 */

	@Override

	protected void setDataProperties() {

		super.setDataProperties();

		dataProperties.setCodeMaxLength(20);

		dataProperties.setCodeFilterSize(10);

		dataProperties.setDescriptionMaxLength(50);

		dataProperties.setDescriptionRequired(false);

		dataProperties.setCancelConfirm(true);

	}



}


