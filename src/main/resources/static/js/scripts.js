document.addEventListener('DOMContentLoaded', function() {
    const courses = [
        {
            id: 1,
            title: 'Curso de Desarrollo Web',
            materials: ['Introducción a HTML', 'CSS Básico', 'JavaScript Esencial'],
            classes: [
                { title: 'Clase 1: HTML', date: '2024-06-25', time: '10:00 AM', professor: 'Juan Pérez' },
                { title: 'Clase 2: CSS', date: '2024-06-26', time: '11:00 AM', professor: 'María López' },
                { title: 'Clase 3: JavaScript', date: '2024-06-27', time: '12:00 PM', professor: 'Carlos García' }
            ]
        },
        {
            id: 2,
            title: 'Curso de Bases de Datos',
            materials: ['Introducción a SQL', 'Modelado de Datos', 'Optimización de Consultas'],
            classes: [
                { title: 'Clase 1: SQL Básico', date: '2024-06-28', time: '02:00 PM', professor: 'Ana Martínez' },
                { title: 'Clase 2: Modelado de Datos', date: '2024-06-29', time: '03:00 PM', professor: 'Luis Fernández' }
            ]
        }
    ];

    const coursesContainer = document.getElementById('courses');

    courses.forEach(course => {
        const courseCard = document.createElement('div');
        courseCard.className = 'card course-card';

        const courseHeader = document.createElement('div');
        courseHeader.className = 'card-header course-title';
        courseHeader.innerText = course.title;

        const courseBody = document.createElement('div');
        courseBody.className = 'card-body';

        const materialsTitle = document.createElement('h5');
        materialsTitle.innerText = 'Materiales:';
        courseBody.appendChild(materialsTitle);

        const materialsList = document.createElement('ul');
        materialsList.className = 'materials-list';
        course.materials.forEach(material => {
            const materialItem = document.createElement('li');
            materialItem.className = 'material-item';
            materialItem.innerText = material;
            materialsList.appendChild(materialItem);
        });
        courseBody.appendChild(materialsList);

        const classesTitle = document.createElement('h5');
        classesTitle.innerText = 'Clases Pendientes:';
        courseBody.appendChild(classesTitle);

        const classesList = document.createElement('ul');
        classesList.className = 'classes-list';
        course.classes.forEach(cl => {
            const classItem = document.createElement('li');
            classItem.className = 'class-item';

            const classTitle = document.createElement('span');
            classTitle.innerText = `Clase: ${cl.title}`;

            const classDate = document.createElement('span');
            classDate.innerText = `Fecha: ${cl.date}`;

            const classTime = document.createElement('span');
            classTime.innerText = `Hora: ${cl.time}`;

            const classProfessor = document.createElement('span');
            classProfessor.innerText = `Profesor: ${cl.professor}`;

            classItem.appendChild(classTitle);
            classItem.appendChild(classDate);
            classItem.appendChild(classTime);
            classItem.appendChild(classProfessor);

            classesList.appendChild(classItem);
        });
        courseBody.appendChild(classesList);

        courseCard.appendChild(courseHeader);
        courseCard.appendChild(courseBody);
        coursesContainer.appendChild(courseCard);
    });
});
