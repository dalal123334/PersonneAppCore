import React, { useState } from 'react';
import axios from 'axios';
import keycloak from '../keycloak';

const PersonneForm = ({ onPersonneCreated, personneToEdit, onCancelEdit }) => {
    const [formData, setFormData] = useState({
        nom: personneToEdit?.nom || '',
        prenom: personneToEdit?.prenom || '',
        email: personneToEdit?.email || '',
        telephone: personneToEdit?.telephone || '',
        age: personneToEdit?.age || 0,
        adresse: personneToEdit?.adresse || ''
    });

    const handleSubmit = async (e) => {
        e.preventDefault();
        const config = {
            headers: {
                Authorization: `Bearer ${keycloak.token}`,
                'Content-Type': 'application/json'
            }
        };

        try {
            if (personneToEdit?.id) {
                await axios.put(`http://localhost:8081/api/personnes/${personneToEdit.id}`, formData, config);
            } else {
                await axios.post('http://localhost:8081/api/personnes', formData, config);
            }
            onPersonneCreated();
            setFormData({
                nom: '',
                prenom: '',
                email: '',
                telephone: '',
                age: 0,
                adresse: ''
            });
        } catch (error) {
            console.error('Erreur lors de la sauvegarde:', error);
        }
    };

    return (
        <form onSubmit={handleSubmit} className="personne-form">
            <div className="form-group">
                <label>Nom:</label>
                <input
                    type="text"
                    value={formData.nom}
                    onChange={(e) => setFormData({ ...formData, nom: e.target.value })}
                    required
                />
            </div>
            <div className="form-group">
                <label>Prénom:</label>
                <input
                    type="text"
                    value={formData.prenom}
                    onChange={(e) => setFormData({ ...formData, prenom: e.target.value })}
                    required
                />
            </div>
            <div className="form-group">
                <label>Email:</label>
                <input
                    type="email"
                    value={formData.email}
                    onChange={(e) => setFormData({ ...formData, email: e.target.value })}
                    required
                />
            </div>
            <div className="form-group">
                <label>Téléphone:</label>
                <input
                    type="text"
                    value={formData.telephone}
                    onChange={(e) => setFormData({ ...formData, telephone: e.target.value })}
                />
            </div>
            <div className="form-group">
                <label>Âge:</label>
                <input
                    type="number"
                    value={formData.age}
                    onChange={(e) => setFormData({ ...formData, age: parseInt(e.target.value) })}
                />
            </div>
            <div className="form-group">
                <label>Adresse:</label>
                <input
                    type="text"
                    value={formData.adresse}
                    onChange={(e) => setFormData({ ...formData, adresse: e.target.value })}
                />
            </div>
            <div className="form-actions">
                <button type="submit">{personneToEdit ? 'Modifier' : 'Créer'}</button>
                {personneToEdit && (
                    <button type="button" onClick={onCancelEdit}>Annuler</button>
                )}
            </div>
        </form>
    );
};

export default PersonneForm; 