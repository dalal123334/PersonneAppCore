import React, { useState, useEffect } from 'react';
import axios from 'axios';
import keycloak from '../keycloak';

const PersonneList = ({ onEditPersonne }) => {
    const [personnes, setPersonnes] = useState([]);

    const fetchPersonnes = async () => {
        try {
            const response = await axios.get('http://localhost:8081/api/personnes', {
                headers: {
                    Authorization: `Bearer ${keycloak.token}`,
                    'Content-Type': 'application/json'
                }
            });
            setPersonnes(response.data);
        } catch (error) {
            console.error('Erreur lors du chargement des personnes:', error);
        }
    };

    useEffect(() => {
        fetchPersonnes();
    }, []);

    const handleDelete = async (id) => {
        try {
            await axios.delete(`http://localhost:8081/api/personnes/${id}`, {
                headers: {
                    Authorization: `Bearer ${keycloak.token}`,
                    'Content-Type': 'application/json'
                }
            });
            fetchPersonnes();
        } catch (error) {
            console.error('Erreur lors de la suppression:', error);
        }
    };

    return (
        <div className="personne-list">
            <h2>Liste des personnes</h2>
            <table>
                <thead>
                    <tr>
                        <th>Nom</th>
                        <th>Prénom</th>
                        <th>Email</th>
                        <th>Téléphone</th>
                        <th>Âge</th>
                        <th>Adresse</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    {personnes.map((personne) => (
                        <tr key={personne.id}>
                            <td>{personne.nom}</td>
                            <td>{personne.prenom}</td>
                            <td>{personne.email}</td>
                            <td>{personne.telephone}</td>
                            <td>{personne.age}</td>
                            <td>{personne.adresse}</td>
                            <td>
                                <button onClick={() => onEditPersonne(personne)}>Modifier</button>
                                <button onClick={() => handleDelete(personne.id)}>Supprimer</button>
                            </td>
                        </tr>
                    ))}
                </tbody>
            </table>
        </div>
    );
};

export default PersonneList; 