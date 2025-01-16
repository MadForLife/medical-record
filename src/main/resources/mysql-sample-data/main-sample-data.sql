
#
# ======================= Users =======================
#

INSERT INTO users (users_id, users_first_name, users_last_name)
VALUES ('86e5e618-eace-4c1c-8e25-b62d3de278f2', 'Frances', 'Miranda');

INSERT INTO users (users_id, users_first_name, users_last_name)
VALUES ('7db4f026-df45-47ca-b3b9-919e6656b405', 'Lara', 'Lynch');

INSERT INTO users (users_id, users_first_name, users_last_name)
VALUES ('ce3f8e75-e8b1-4531-beb3-da471b1590b0', 'Azaan', 'Bush');

INSERT INTO users (users_id, users_first_name, users_last_name)
VALUES ('76f71696-7227-4b60-b2d5-12a19f67ff78', 'Harvey', 'Lindsay');

INSERT INTO users (users_id, users_first_name, users_last_name)
VALUES ('dfd58654-d3db-407f-afb1-2c637a636704', 'Sahar', 'Webster');

INSERT INTO users (users_id, users_first_name, users_last_name)
VALUES ('404042c6-51cf-4611-80db-19d48e3ce5b6', 'Gina', 'Duran');

INSERT INTO users (users_id, users_first_name, users_last_name)
VALUES ('4f25226f-4be7-424e-94ac-d4b1fa4caa41', 'Sylvia', 'Bradshaw');

INSERT INTO users (users_id, users_first_name, users_last_name)
VALUES ('c8b99890-0439-43a9-8dec-50af983eeae6', 'Huda', 'Poole');

INSERT INTO users (users_id, users_first_name, users_last_name)
VALUES ('cff5b8f7-fe5c-460b-947c-735611646f36', 'Arianna', 'Ali');

INSERT INTO users (users_id, users_first_name, users_last_name)
VALUES ('cc6bfe83-a41e-4390-960d-b63ffc20f6e7', 'Kaine', 'Gibson');

INSERT INTO users (users_id, users_first_name, users_last_name)
VALUES ('b3b3854e-25ec-41ae-a81a-57cb55df1b59', 'Anton', 'Wheeler');

INSERT INTO users (users_id, users_first_name, users_last_name)
VALUES ('b69f5420-2b3f-4eea-a6e0-3c802aa4d3c1', 'Christopher', 'Pruitt');

#
# ======================= Doctors =======================
#

INSERT INTO doctor (users_id, doctor_is_personal_doctor)
VALUES ('404042c6-51cf-4611-80db-19d48e3ce5b6', b'1');

INSERT INTO doctor (users_id, doctor_is_personal_doctor)
VALUES ('4f25226f-4be7-424e-94ac-d4b1fa4caa41', b'1');

INSERT INTO doctor (users_id, doctor_is_personal_doctor)
VALUES ('76f71696-7227-4b60-b2d5-12a19f67ff78', b'1');

INSERT INTO doctor (users_id, doctor_is_personal_doctor)
VALUES ('7db4f026-df45-47ca-b3b9-919e6656b405', b'0');

INSERT INTO doctor (users_id, doctor_is_personal_doctor)
VALUES ('86e5e618-eace-4c1c-8e25-b62d3de278f2', b'0');

#
# ======================= Patients =======================
#

INSERT INTO patient (users_id, patient_ucn, patient_is_health_insured, doctors_id)
VALUES ('b3b3854e-25ec-41ae-a81a-57cb55df1b59', '4323830972', b'1', '404042c6-51cf-4611-80db-19d48e3ce5b6');

INSERT INTO patient (users_id, patient_ucn, patient_is_health_insured, doctors_id)
VALUES ('b69f5420-2b3f-4eea-a6e0-3c802aa4d3c1', '2091886112', b'1', '404042c6-51cf-4611-80db-19d48e3ce5b6');

INSERT INTO patient (users_id, patient_ucn, patient_is_health_insured, doctors_id)
VALUES ('dfd58654-d3db-407f-afb1-2c637a636704', '5016766215', b'0', '404042c6-51cf-4611-80db-19d48e3ce5b6');

INSERT INTO patient (users_id, patient_ucn, patient_is_health_insured, doctors_id)
VALUES ('c8b99890-0439-43a9-8dec-50af983eeae6', '6940871178', b'1', '4f25226f-4be7-424e-94ac-d4b1fa4caa41');

INSERT INTO patient (users_id, patient_ucn, patient_is_health_insured, doctors_id)
VALUES ('cc6bfe83-a41e-4390-960d-b63ffc20f6e7', '7579083667', b'1', '4f25226f-4be7-424e-94ac-d4b1fa4caa41');

INSERT INTO patient (users_id, patient_ucn, patient_is_health_insured, doctors_id)
VALUES ('ce3f8e75-e8b1-4531-beb3-da471b1590b0', '8935334922', b'0', '76f71696-7227-4b60-b2d5-12a19f67ff78');

INSERT INTO patient (users_id, patient_ucn, patient_is_health_insured, doctors_id)
VALUES ('cff5b8f7-fe5c-460b-947c-735611646f36', '5809292971', b'0', '76f71696-7227-4b60-b2d5-12a19f67ff78');

#
# ======================= Doc Specialities =======================
#

INSERT INTO doc_specialities (id, doc_spec_name, doc_spec_description)
VALUES ('671928be-dd6d-4235-bab4-7c7df42a0f1a', 'Neurologist',
        'A neurologist is trained in the brain and nervous system. They diagnose, manage and treat many conditions, like Alzheimer''s disease, epilepsy ..');

INSERT INTO doc_specialities (id, doc_spec_name, doc_spec_description)
VALUES ('bdcb0a60-94ff-4e97-9634-7e44fcf83d2f', 'Family medicine', 'Family medicine is a medical specialty within primary care that provides continuing and comprehensive health care for the individual and family across all ages, genders, diseases, and parts of the body. The specialist, who is usually a primary care physician, is named a family physician.');

INSERT INTO doc_specialities (id, doc_spec_name, doc_spec_description)
VALUES ('843041b3-58b6-4a32-8d1e-945995a2925e', 'Dermatology',
        'Dermatology is the branch of medicine dealing with the skin. It is a speciality with both medical and surgical aspects. A dermatologist is a specialist medical doctor who manages diseases related to skin, hair, nails, and some cosmetic problems.');

INSERT INTO doc_specialities (id, doc_spec_name, doc_spec_description)
VALUES ('d1ee29c3-6a39-40c7-afa3-ca4f399b57a6', 'Allergist',
        'An allergist is a physician specially trained to manage and treat allergies, asthma and the other allergic diseases. They may also be called immunologists.');

#
# ======================= Doc Has Specialities =======================
#

INSERT INTO doc_has_specialities (doctors_id, doc_spec_id)
VALUES ('404042c6-51cf-4611-80db-19d48e3ce5b6', '671928be-dd6d-4235-bab4-7c7df42a0f1a');

INSERT INTO doc_has_specialities (doctors_id, doc_spec_id)
VALUES ('404042c6-51cf-4611-80db-19d48e3ce5b6', '843041b3-58b6-4a32-8d1e-945995a2925e');

INSERT INTO doc_has_specialities (doctors_id, doc_spec_id)
VALUES ('4f25226f-4be7-424e-94ac-d4b1fa4caa41', '843041b3-58b6-4a32-8d1e-945995a2925e');

INSERT INTO doc_has_specialities (doctors_id, doc_spec_id)
VALUES ('76f71696-7227-4b60-b2d5-12a19f67ff78', 'd1ee29c3-6a39-40c7-afa3-ca4f399b57a6');

INSERT INTO doc_has_specialities (doctors_id, doc_spec_id)
VALUES ('7db4f026-df45-47ca-b3b9-919e6656b405', 'bdcb0a60-94ff-4e97-9634-7e44fcf83d2f');

INSERT INTO doc_has_specialities (doctors_id, doc_spec_id)
VALUES ('86e5e618-eace-4c1c-8e25-b62d3de278f2', '671928be-dd6d-4235-bab4-7c7df42a0f1a');

#
# ======================= Appointments =======================
#

INSERT INTO appointments (id, doctors_id, patients_id, appointments_visit_date)
VALUES ('506db185-3e1e-45ab-aa9e-7db60ac17eb2', '404042c6-51cf-4611-80db-19d48e3ce5b6', 'b3b3854e-25ec-41ae-a81a-57cb55df1b59', '2025-01-20');

INSERT INTO appointments (id, doctors_id, patients_id, appointments_visit_date)
VALUES ('eb6860ff-1334-4b74-a52f-7f0e1806d453', '76f71696-7227-4b60-b2d5-12a19f67ff78', 'cc6bfe83-a41e-4390-960d-b63ffc20f6e7', '2025-01-20');

INSERT INTO appointments (id, doctors_id, patients_id, appointments_visit_date)
VALUES ('0a00b929-010e-4413-a3a6-307810f525df', '4f25226f-4be7-424e-94ac-d4b1fa4caa41', 'ce3f8e75-e8b1-4531-beb3-da471b1590b0', '2025-01-20');

INSERT INTO appointments (id, doctors_id, patients_id, appointments_visit_date)
VALUES ('ce2f61e9-5573-4c51-9273-781bb9c8da1f', '404042c6-51cf-4611-80db-19d48e3ce5b6', 'cff5b8f7-fe5c-460b-947c-735611646f36', '2025-01-20');

INSERT INTO appointments (id, doctors_id, patients_id, appointments_visit_date)
VALUES ('13180fe7-35df-4ff4-af2c-94b3b76a6072', '76f71696-7227-4b60-b2d5-12a19f67ff78', 'b3b3854e-25ec-41ae-a81a-57cb55df1b59', '2025-01-20');

#
# ======================= Sick Leaves =======================
#

INSERT INTO sick_leaves (id, appointments_id, sl_reason, sl_start_date, sl_end_date)
VALUES ('01fc1944-c036-4bc2-98a4-81754f3f194d', '506db185-3e1e-45ab-aa9e-7db60ac17eb2', 'null', '2025-01-25', '2025-02-02');

INSERT INTO sick_leaves (id, appointments_id, sl_reason, sl_start_date, sl_end_date)
VALUES ('54b31c1c-7093-48f4-a108-2094761715a2', 'eb6860ff-1334-4b74-a52f-7f0e1806d453', 'null', '2025-01-25', '2025-02-02');

INSERT INTO sick_leaves (id, appointments_id, sl_reason, sl_start_date, sl_end_date)
VALUES ('58a0c044-8c7c-440e-bc57-8ba0df4a294e', '0a00b929-010e-4413-a3a6-307810f525df', 'null', '2025-01-25', '2025-02-02');

#
# ======================= Medicines =======================
#

INSERT INTO medicines (id, medicine_name, medicine_description)
VALUES ('4515892f-a545-4d68-8cb0-b9c36b4bcc69', 'Fluticasone', 'A nasal spray for allergic rhinitis');

INSERT INTO medicines (id, medicine_name, medicine_description)
VALUES ('5c670241-bc82-4755-838c-f3ba82cf2751', 'Amoxicillin', 'A commonly used antibiotic for bacterial infections');

INSERT INTO medicines (id, medicine_name, medicine_description)
VALUES ('1f045ad3-d2d3-4ee6-9255-e81748ac3b95', 'Sumatriptan', 'For migraines or cluster headaches');

INSERT INTO medicines (id, medicine_name, medicine_description)
VALUES ('84b974f4-28db-4c4d-bca9-ed1cf702a146', 'Fexofenadine', 'For seasonal allergies or chronic urticaria');

INSERT INTO medicines (id, medicine_name, medicine_description)
VALUES ('6aefec03-f7c4-4b28-a11d-c0708249cef5', 'Ibuprofen', 'For pain relief or inflammation');

#
# ======================= Diagnose Codes =======================
#

INSERT INTO diagnose_code_list (id, dc_name)
VALUES ('70d437e9-f796-4a44-90b3-ff4d8a1a6b37', 'L40.0');

INSERT INTO diagnose_code_list (id, dc_name)
VALUES ('f269968f-cd8b-4dd9-99cc-343e5eaccbfe', 'G40.909');

INSERT INTO diagnose_code_list (id, dc_name)
VALUES ('878e0529-509f-4524-a448-bd2886edeb3a', 'J30.1');

INSERT INTO diagnose_code_list (id, dc_name)
VALUES ('05d83c54-48b7-4b67-afa5-4c33b2b3a592', 'E11.9');

#
# ======================= Prescriptions =======================
#

INSERT INTO prescriptions (id, appointments_id, prescription_description)
VALUES ('00be582c-ac16-4765-8c61-809dbcbfaa86', '506db185-3e1e-45ab-aa9e-7db60ac17eb2', 'null');

INSERT INTO prescriptions (id, appointments_id, prescription_description)
VALUES ('4bd4df8b-e8f2-4495-9a7f-0050919d2773', 'eb6860ff-1334-4b74-a52f-7f0e1806d453', 'null');

INSERT INTO prescriptions (id, appointments_id, prescription_description)
VALUES ('096e7072-9b0f-4301-86e2-0b70d1c8244b', '0a00b929-010e-4413-a3a6-307810f525df', 'null');

#
# ======================= Diagnoses =======================
#

INSERT INTO diagnoses (id, appointments_id, dcl_id, diagnose_description)
VALUES ('b49132ee-0e43-4967-913c-084ef0d0a455', '506db185-3e1e-45ab-aa9e-7db60ac17eb2', '70d437e9-f796-4a44-90b3-ff4d8a1a6b37', 'null');

INSERT INTO diagnoses (id, appointments_id, dcl_id, diagnose_description)
VALUES ('c5ab6139-29e1-4c91-beaa-9d2eb90400a5', 'eb6860ff-1334-4b74-a52f-7f0e1806d453', 'f269968f-cd8b-4dd9-99cc-343e5eaccbfe', 'null');

INSERT INTO diagnoses (id, appointments_id, dcl_id, diagnose_description)
VALUES ('95a75361-7627-4467-a94b-c85ba9b168bf', '0a00b929-010e-4413-a3a6-307810f525df', '878e0529-509f-4524-a448-bd2886edeb3a', 'null');

#
# ======================= Prescription Has Medicines =======================
#

INSERT INTO prescription_has_medicines (prescriptions_id, medicines_id)
VALUES ('00be582c-ac16-4765-8c61-809dbcbfaa86', '4515892f-a545-4d68-8cb0-b9c36b4bcc69');

INSERT INTO prescription_has_medicines (prescriptions_id, medicines_id)
VALUES ('00be582c-ac16-4765-8c61-809dbcbfaa86', '5c670241-bc82-4755-838c-f3ba82cf2751');

INSERT INTO prescription_has_medicines (prescriptions_id, medicines_id)
VALUES ('4bd4df8b-e8f2-4495-9a7f-0050919d2773', '84b974f4-28db-4c4d-bca9-ed1cf702a146');

INSERT INTO prescription_has_medicines (prescriptions_id, medicines_id)
VALUES ('096e7072-9b0f-4301-86e2-0b70d1c8244b', '5c670241-bc82-4755-838c-f3ba82cf2751');