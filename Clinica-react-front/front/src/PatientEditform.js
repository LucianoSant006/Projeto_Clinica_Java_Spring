import React, {useState} from 'react'
import axios from 'axios';

const PatientEditForm = ({patient, onSave}) => {
    const [nome,setNome] = useState(patient.nome);
    const[cpf,setCpf] = useState (patient.cpf);

    const handleSave = async () => {
        try{
            const updatePatient = {id: patient.id,nome,cpf};
            await axios.put(`/api/patients/${patient.id}`,updatePatient);
            console.log(`Patient com ID ${patient.id} atualizado com sucesso.`);
            onSave();
        }
        catch (error){
            console.error(`Error ao atualizar patient com ID ${patient.id}:`,error);

        }
    };
    return(
        <div>
            <h3>editando Patient</h3>
            <input type="text" value={nome} onChange={(e) => setNome(e.target.value)} placeholder="NOME"/>
            <input type="text" value={cpf} onChange={(e) => setCpf(e.target.value)} placeholder="CPF"/>
            <button onClick={handleSave}>Salvar</button>
        </div>
    );
};
export default PatientEditForm;