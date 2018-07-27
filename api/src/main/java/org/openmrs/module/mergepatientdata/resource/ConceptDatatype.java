package org.openmrs.module.mergepatientdata.resource;

import org.openmrs.BaseOpenmrsObject;

public class ConceptDatatype implements MergeAbleResource {
	
	public String uuid;
	
	public Integer id;
	
	// HL7 abbreviations (along with our own boolean creature)
	
	public static final String BOOLEAN = "BIT";
	
	public static final String CODED = "CWE";
	
	public static final String DATE = "DT";
	
	public static final String DATETIME = "TS";
	
	public static final String DOCUMENT = "RP";
	
	public static final String NUMERIC = "NM";
	
	public static final String TEXT = "ST";
	
	public static final String TIME = "TM";
	
	// UUIDs for core datatypes
	
	public static final String NUMERIC_UUID = "8d4a4488-c2cc-11de-8d13-0010c6dffd0f";
	
	public static final String CODED_UUID = "8d4a48b6-c2cc-11de-8d13-0010c6dffd0f";
	
	public static final String TEXT_UUID = "8d4a4ab4-c2cc-11de-8d13-0010c6dffd0f";
	
	public static final String N_A_UUID = "8d4a4c94-c2cc-11de-8d13-0010c6dffd0f";
	
	public static final String DOCUMENT_UUID = "8d4a4e74-c2cc-11de-8d13-0010c6dffd0f";
	
	public static final String DATE_UUID = "8d4a505e-c2cc-11de-8d13-0010c6dffd0f";
	
	public static final String TIME_UUID = "8d4a591e-c2cc-11de-8d13-0010c6dffd0f";
	
	public static final String DATETIME_UUID = "8d4a5af4-c2cc-11de-8d13-0010c6dffd0f";
	
	public static final String BOOLEAN_UUID = "8d4a5cca-c2cc-11de-8d13-0010c6dffd0f";
	
	public static final String RULE_UUID = "8d4a5e96-c2cc-11de-8d13-0010c6dffd0f";
	
	public static final String STRUCTURED_NUMERIC_UUID = "8d4a606c-c2cc-11de-8d13-0010c6dffd0f";
	
	public static final String COMPLEX_UUID = "8d4a6242-c2cc-11de-8d13-0010c6dffd0f";
	
	private Integer conceptDatatypeId;
	
	private String hl7Abbreviation;
	
	private String description;
	
	private String name;
	
	// Constructors
	
	/** default constructor */
	public ConceptDatatype() {
	}
	
	public ConceptDatatype(org.openmrs.ConceptDatatype type) {
		this.conceptDatatypeId = type.getConceptDatatypeId();
		this.hl7Abbreviation = type.getHl7Abbreviation();
		this.uuid = type.getUuid();
		this.description = type.getDescription();
		this.name = type.getName();
	}
	
	@Override
	public BaseOpenmrsObject getOpenMrsObject() {
		org.openmrs.ConceptDatatype type = new org.openmrs.ConceptDatatype(this.conceptDatatypeId);
		type.setHl7Abbreviation(hl7Abbreviation);
		type.setUuid(uuid);
		type.setDescription(description);
		type.setName(name);
		return type;
	}
	
	// Property accessors
	
	public Integer getConceptDatatypeId() {
		return this.conceptDatatypeId;
	}
	
	public void setConceptDatatypeId(Integer conceptDatatypeId) {
		this.conceptDatatypeId = conceptDatatypeId;
	}
	
	/**
	 * @return Returns the hl7Abbreviation.
	 */
	public String getHl7Abbreviation() {
		return hl7Abbreviation;
	}
	
	/**
	 * @param hl7Abbreviation The hl7Abbreviation to set.
	 */
	public void setHl7Abbreviation(String hl7Abbreviation) {
		this.hl7Abbreviation = hl7Abbreviation;
	}
	
	/*
	 * Convenience methods for resolving common data types
	 */
	
	/**
	 * @return <code>true</code> if datatype is N/A, i.e. this concept is only an answer, not a
	 *         question
	 */
	public boolean isAnswerOnly() {
		return N_A_UUID.equals(getUuid());
	}
	
	/**
	 * @return <code>true</code> if datatype is a numeric datatype
	 */
	public boolean isNumeric() {
		return NUMERIC_UUID.equals(getUuid());
	}
	
	/**
	 * @return <code>true</code> if datatype is coded (i.e., an identifier from a vocabulary)
	 */
	public boolean isCoded() {
		return CODED_UUID.equals(getUuid());
	}
	
	/**
	 * @return <code>true</code> if datatype is representation of date (but NOT a time or
	 *         datatime--see containsDate() and containsTime())
	 */
	public boolean isDate() {
		return DATE_UUID.equals(getUuid());
	}
	
	/**
	 * @return <code>true</code> if datatype is representation of time
	 * @since 1.7
	 */
	public boolean isTime() {
		return TIME_UUID.equals(getUuid());
	}
	
	/**
	 * @return <code>true</code> if datatype is representation of Datetime
	 * @since 1.7
	 */
	public boolean isDateTime() {
		return DATETIME_UUID.equals(getUuid());
	}
	
	/**
	 * @return <code>true</code> if datatype is representation of either date or Datetime
	 * @since 1.7
	 */
	public boolean containsDate() {
		return DATE_UUID.equals(getUuid()) || DATETIME_UUID.equals(getUuid());
	}
	
	/**
	 * @return <code>true</code> if datatype is representation of either time or Datetime
	 * @since 1.7
	 */
	public boolean containsTime() {
		return TIME_UUID.equals(getUuid()) || DATETIME_UUID.equals(getUuid());
	}
	
	/**
	 * @return <code>true</code> if datatype is text-based
	 */
	public boolean isText() {
		return TEXT_UUID.equals(getUuid()) || DOCUMENT_UUID.equals(getUuid());
	}
	
	/**
	 * @return <code>true</code> if datatype is boolean
	 */
	public boolean isBoolean() {
		return BOOLEAN_UUID.equals(getUuid());
	}
	
	/**
	 * @since 1.5
	 * @see org.openmrs.OpenmrsObject#getId()
	 */
	public Integer getId() {
		
		return getConceptDatatypeId();
	}
	
	/**
	 * @since 1.5
	 * @see org.openmrs.OpenmrsObject#setId(java.lang.Integer)
	 */
	public void setId(Integer id) {
		setConceptDatatypeId(id);
		
	}
	
	/**
	 * @return <code>true</code> if datatype is complex
	 * @since 1.7
	 */
	public boolean isComplex() {
		return COMPLEX_UUID.equals(getUuid());
	}
	
	/**
	 * @return <code>true</code> if datatype is a rule
	 * @since 1.7
	 */
	public boolean isRule() {
		return RULE_UUID.equals(getUuid());
	}
	
	public String getUuid() {
		return uuid;
	}
	
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}