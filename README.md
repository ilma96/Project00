# <h1> Project0 </h1>
<p>Fast Food Ordering App (Beginner Level) using MS SQL Server through Docker and designing database using Dbeaver.</p>
<ul>
<li> In the beginning, <e>four</e> options are given before the user. The user can  <b>view the food menu</b> (The menu is a table designed on Dbeaver connected to the MS SQL Server from port 1433) or go to <b>advanced options</b> or choose to quit. There is another option that is <b>administrator options</b>, which requires login. That option allows a MenuAdministrator to update a row on the Menu table. That option is not meant for the Customer. Hence, the added layer of security. The user can choose <b>quit</b> to gracefully exit the program</li> 
<li> After typing <b>advanced options</b>, the user sees <e>five</e> more options. The user can <b>add a food item</b> to their Cart or <b>remove a food item</b> from their Cart or <b>view cart</b> or <b>view total price</b> or <b>finish</b> to gracefully exit the program</li>
<li>Now here is the caveat: the user cannot add a food item to their cart that does not exist in the menu. Surely they can insert garbage data on Cart table but neither of those data are added to their cart nor their total price is calculated from those data. The user cannot type an ID that is not on the Menu table as that violates the Foreign Key Constraint, thus, throwing an SQL exception.</li>
</ul>
