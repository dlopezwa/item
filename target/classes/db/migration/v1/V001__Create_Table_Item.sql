CREATE TABLE IF NOT EXISTS item (
    id SERIAL NOT NULL PRIMARY KEY,
    name varchar(20) NOT NULL,
    description varchar(50) NOT NULL
);

insert into item(name, description) values
('caja', 'caja de contenido indefinido'),
('marioneta', 'Marioneta de felpa que hace bolas'),
('bolígrafo', 'un bolígrafo bic de antes del big ban'),
('clínex', 'Pañuelos polivalentes');