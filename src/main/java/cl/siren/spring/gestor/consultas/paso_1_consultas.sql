# Consulta 1
# Se solicita mostrar el nombre de cada paciente y el nombre del doctor con el que tienen
# una cita asignada.
SELECT P.Nombre AS Nombre_Paciente, D.Nombre AS Nombre_Doctor
FROM Citas C
JOIN Pacientes P ON C.Paciente_ID = P.ID
JOIN Doctores D ON C.Doctor_ID = D.ID;

# Consulta 2
# Se solicita una lista del Nombre y la Especialidad de todos los doctores que atendieron al
# paciente “Juan Pérez”
SELECT D.Nombre AS Nombre_Doctor, E.Nombre AS Especialidad
FROM Citas C
JOIN Pacientes P ON C.Paciente_ID = P.ID
JOIN Doctores D ON C.Doctor_ID = D.ID
JOIN Especialidades E ON D.Especialidad_ID = E.ID
WHERE P.Nombre = 'Juan Pérez';

# Consulta 3
# Se solicita una lista con el monto que factura cada doctor, ordenados alfabéticamente de
# forma descendente, agrupados por el nombre del Doctor.
SELECT D.Nombre AS Nombre_Doctor, SUM(F.Monto) AS Monto_Total
FROM Citas C
JOIN Doctores D ON C.Doctor_ID = D.ID
JOIN Facturas F ON C.Factura_ID = F.ID
GROUP BY D.Nombre
ORDER BY Nombre_Doctor DESC;

# Consulta 4
# Se solicita una lista que muestre por paciente, el diagnóstico y tratamiento que recibió en
# su última cita. Ordenados de forma ascendente por el id del paciente.
SELECT P.Nombre AS Nombre_Paciente, HC.Diagnostico, HC.Tratamiento
FROM Historia_Clinica HC
JOIN Pacientes P ON HC.Paciente_ID = P.ID
WHERE HC.ID IN (
    SELECT MAX(ID) FROM Historia_Clinica GROUP BY Paciente_ID
)
ORDER BY P.ID ASC;

# Consulta 5
# Se solicita una lista con la cantidad de pacientes que ha atendido cada doctor.
SELECT D.Nombre AS Nombre_Doctor, COUNT(C.ID) AS Cantidad_Pacientes_Atendidos
FROM Doctores D
LEFT JOIN Citas C ON D.ID = C.Doctor_ID
GROUP BY D.ID;
