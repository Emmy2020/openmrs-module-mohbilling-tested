/**
 * The contents of this file are subject to the OpenMRS Public License
 * Version 1.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * http://license.openmrs.org
 *
 * Software distributed under the License is distributed on an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific language governing rights and limitations
 * under the License.
 *
 * Copyright (C) OpenMRS, LLC.  All Rights Reserved.
 */
package org.openmrs.module.mohbilling.db;

import java.util.Date;
import java.util.List;

import org.openmrs.api.db.DAOException;
import org.openmrs.module.mohbilling.model.BillableService;
import org.openmrs.module.mohbilling.model.FacilityServicePrice;
import org.openmrs.module.mohbilling.model.Insurance;
import org.openmrs.module.mohbilling.model.InsurancePolicy;
import org.openmrs.module.mohbilling.model.PatientBill;
import org.openmrs.module.mohbilling.model.Recovery;
import org.openmrs.module.mohbilling.model.ServiceCategory;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Kamonyo
 * 
 */
@Transactional
public interface BillingDAO {

	/**
	 * Gets the Patient Bill from the DB by specifying the Object/ID
	 * 
	 * @param bill
	 *            , the bill to be matched
	 * @return patientBill, the bill that was matched by the entered object.
	 *         Otherwise it returns Null Object
	 * 
	 * @throws DAOException
	 */
	public PatientBill getPatientBill(Integer billId) throws DAOException;

	/**
	 * Gets all existing PatientBills
	 * 
	 * @return <code>List<PatientBill></code> a list of PatientBill
	 * 
	 * @throws DAOException
	 */
	public List<PatientBill> getAllPatientBills() throws DAOException;

	/**
	 * Gets the insurance from the DB by specifying the Object/ID
	 * 
	 * @param insurance
	 *            , the insurance to be matched
	 * @return insurance, the insurance that was matched by the entered object.
	 *         Otherwise it returns Null Object
	 * 
	 * @throws DAOException
	 */
	public Insurance getInsurance(Integer insuranceId) throws DAOException;

	/**
	 * Gets all existing Insurances
	 * 
	 * @return <code>List<Insurance></code> a list of Insurance
	 * 
	 * @throws DAOException
	 */
	public List<Insurance> getAllInsurances() throws DAOException;

	/**
	 * Gets Insurance Policy from the DB by specifying the Object/ID
	 * 
	 * @param card
	 *            , the insurance policy to be matched
	 * @return card, the card that was matched by the entered object. Otherwise
	 *         it returns Null Object
	 * 
	 * @throws DAOException
	 */
	public InsurancePolicy getInsurancePolicy(Integer insurancePolicyId)
			throws DAOException;

	/**
	 * Gets all existing InsurancePolicies
	 * 
	 * @return <code>List<InsurancePolicy></code> a list of InsurancePolicy
	 * 
	 * @throws DAOException
	 */
	public List<InsurancePolicy> getAllInsurancePolicies() throws DAOException;

	/**
	 * Saves the Patient Bill to the DB by passing the Object to be saved
	 * 
	 * @param bill
	 *            , the bill to be saved
	 * 
	 * @throws DAOException
	 */
	public void savePatientBill(PatientBill bill) throws DAOException;

	/**
	 * Saves the Insurance to the DB by passing the Object to be saved
	 * 
	 * @param insurance
	 *            , the insurance to be saved
	 * 
	 * @throws DAOException
	 */
	public void saveInsurance(Insurance insurance) throws DAOException;

	/**
	 * Saves the Insurance Policy to the DB by passing the Object to be saved
	 * 
	 * @param card
	 *            , the card to be saved
	 * 
	 * @param card
	 * @throws DAOException
	 */
	public void saveInsurancePolicy(InsurancePolicy card) throws DAOException;

	/**
	 * Gets a Facility Service Price to the DB
	 * 
	 * @param id
	 *            , The Facility Service Price ID to be matched
	 * @return the matched Facility Service Price
	 * 
	 * @throws DAOException
	 */
	public FacilityServicePrice getFacilityServicePrice(Integer id)
			throws DAOException;

	/**
	 * Gets all existing Service Categorie from the DB
	 * 
	 * @return list of Service Categorie Prices
	 * @throws DAOException
	 */
	public List<ServiceCategory> getAllServiceCategories() throws DAOException;

	/**
	 * Gets all existing Facility Service Prices from the DB
	 * 
	 * @return list of Facility Service Prices
	 * @throws DAOException
	 */
	public List<FacilityServicePrice> getAllFacilityServicePrices()
			throws DAOException;

	/**
	 * Adds a Facility Service Price to the DB
	 * 
	 * @param fsp
	 *            , the facility service price to save
	 * 
	 * @throws DAOException
	 */
	public void saveFacilityServicePrice(FacilityServicePrice fsp)
			throws DAOException;

	/**
	 * get all billable services
	 * 
	 * @return
	 */

	public List<BillableService> getAllBillableServices();

	public void saveRecovery(Recovery recovery);

	/**
	 * get all billable services
	 * 
	 * @return
	 */
	public Float getPaidAmountPerInsuranceAndPeriod(Insurance insurance,
			Date startDate, Date endDate);

	public List<Recovery> getAllPaidAmountPerInsuranceAndPeriod(
			Insurance insurance, Date startDate, Date endDate);

	/**
	 * Gets the InsurancePolicyCard by unique InsuranceCardNo
	 * 
	 * @param insuranceCardNo
	 *            the unique insurance card number
	 * @return insurancePolicyCard that matches the unique card number
	 */
	public InsurancePolicy getInsurancePolicyByCardNo(String insuranceCardNo);

	/**
	 * Gets all patient bills by entered parameters
	 * 
	 * @param insurance
	 * @param startDate
	 * @param endDate
	 * @param patientId
	 * @param serviceName
	 * @return
	 */
	public List<PatientBill> buildCohort(Insurance insurance, Date startDate,
			Date endDate, Integer patientId, String serviceName,
			String billStatus, String billCollector);

	/**
	 * Gets a BillableService by selecting those having the provided
	 * FacilityServicePrice and the Insurance.
	 * 
	 * @param price
	 *            the FacilityServicePrice
	 * @param insurance
	 *            the Insurance
	 * @return BillableService that matches both FacilityServicePrice and
	 *         Insurance
	 */
	public BillableService getBillableServiceByConcept(
			FacilityServicePrice price, Insurance insurance);
}
