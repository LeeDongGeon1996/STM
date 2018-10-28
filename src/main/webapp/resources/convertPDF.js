function print() {
		const filename  = 'ThisIsYourPDFFilename.pdf';

		html2canvas(document.querySelector('#main_section')).then(canvas => {
			let pdf = new jsPDF('p', 'mm', 'a4');
			pdf.addImage(canvas.toDataURL('image/png'), 'PNG', 0, 0, 211, 298);
			pdf.save(filename);
		});
	}