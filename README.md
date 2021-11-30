# Semestral work - Fitness center datababase

V programu jsou 3 entity - Address, FitnessCenter, Staff. V Gitu je přidaný screenshot s relacemi mezi tabulkami. Do databáze se dají libovolně přidávat adresy a zaměstnanci. Pokud chceme přidat fitko, musíme zadat v http-requestu i ID adresy. Api requesty jsou klasické read/post/put/delete - u všech entit mi dává smysl mít všechny možnosti. Implementované jsou i dva další : \
/fitness_centers/staff/{staff_id} - vypíše všechny fitka, kde pracuje daný zaměstnanec\
/staff/fitness_center/{fc_name} - vypíše všechny zaměstnance pracující v daném fitku

