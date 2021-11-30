# Semestral work - Fitness center datababase

V programu jsou 3 entity - Address, FitnessCenter, Staff. V Gitu je přidaný screenshot s relacemi mezi tabulkami. Do databáze se dají libovolně přidávat adresy a zaměstnanci, fitka jdou přidávat pouze, pokud jim dodáme valdidní id adresy. Pokud chceme přidat fitko, musíme zadat v http-requestu i ID adresy (pokud zadané id není v databázi, nenechá fitko přidat) - Existence fitka v databázi, které nemá adresu mi nedává smysl. Api requesty jsou klasické read/post/put/delete - u všech entit mi dává smysl mít všechny možnosti. Implementované jsou i dva další : \
/fitness_centers/staff/{staff_id} - vypíše všechny fitka, kde pracuje daný zaměstnanec, pokud zaměstance v databázi najde\
/staff/fitness_center/{fc_name} - vypíše všechny zaměstnance pracující v daném fitku, pokud je najde\
\
Jsem připojený na DBS databázi, můj program má v databázi nastaveno UPDATE, takže by data měli zůstat v databázi.\
V databázi by měli být vložená data, i v dbs portálu mi tam zůstávají. Id jsou generovány automaticky pomocí SEQUENCE. \
Jednotlivá id:\
*  1-4 pro adresy
*  6-9 pro fitka
*  11-15 pro zaměstnance

V databázi jsou již existující M:N vazby mezi fitkem a zaměstnanci.\
Doufám, že Vám toto vysvětlení pro pochopení programu bude stačit, pokud ne, napište mi na Teams a dovysvětlím.