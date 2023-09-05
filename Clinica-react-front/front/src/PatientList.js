import React, {useEffect, useState} from 'react'
import axios from 'axios';
const PatientList = ({OnDeleteClick,onEditClick}) =>{
    const [patients, setPatients] = useState([]);

    useEffect(() => {
        fetchPatients();
    },[]
    );

    const fetchPatients = async () => {
        try{
            const response = await axios.get('/api/patients');
            setPatients(response.data);

        }
        catch (error){
            console.error('Error ao buscar patients:',error);
        }
    };
    return(
        <div>
            <h2>Lista de patients</h2>
            <ul>{patients.map(patient => (
                <li key={patient.id} >{patient.nome} - {patient.cpf}
                <button onClick={() =>onDeleteClick(patient.id)}>Excluir</button>
                <button onClick={() =>onEditClick(patient.id)}>Editar</button>

                </li>
                ))}
            </ul>
        </div>
    );
};
export default PatientList