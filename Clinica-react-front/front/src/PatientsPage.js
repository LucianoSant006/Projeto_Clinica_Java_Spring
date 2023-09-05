
import React, {useEffect, useState} from 'react';
import PatientList from './PatientList';
import PatientEditForm from './PatientEditform';

const PatientsPage = () => {
    const [isEditing,setIsEditing] = useState(false);
    const [editingPatientId, setEditingPatientId] = useState(null);

    const handleDeleteClick = (id) => {
        try{
            await axios.delete(`/api/patients/${id}`);
            console.log(`Patient com ID ${id} rxcluido com suceso.`);
            fetchPatients();
        }catch (error){
            console.log(`Erro ao excluir patient com ID ${id}`,error);

        }
    };
const handleEditClick = (id) => {
    setIsEditing(true);
    setEditingPatientId(id);
}
const handleEditFormSave = () => {
    setIsEditing(false);
    setEditingPatientId(null);
    fetchPatients();
}
return(
    <div>
        <h1>Pagina de Patients</h1>
        {isEditing ? (
            <PatientEditForm
            patientId={editingPatientId}
            onSave={handleEditFormSave}
            />
        ) : (
            <PatientList OnDeleteClick={handleDeleteClick} onEditClick={handleEditClick}/>
        )};
        </div>
    )
        };

        export default PatientsPage;
    


