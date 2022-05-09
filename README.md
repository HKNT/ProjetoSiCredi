# prova_sicredi

teste SiCredi

Tarefa 1:
Acessar a página:  https://www.grocerycrud.com/v1.x/demo/my_boss_is_in_a_hurry/bootstrap
Mudar o valor da combo Select version para “Bootstrap V4 Theme”
Clicar no botão Add Customer

Preencher os campos do formulário com as seguintes informações:

Name: Teste Sicredi
Last name: Teste
ContactFirstName: seu nome
Phone: 51 9999-9999
AddressLine1: Av Assis Brasil, 3970
AddressLine2: Torre D
City: Porto Alegre
State: RS
PostalCode: 91000-000
Country: Brasil
from Employeer: Fixter
CreditLimit: 200

Clicar no botão Save
Validar a mensagem “Your data has been successfully stored into the database. Edit Customer or Go back to list” através de uma asserção
Fechar o browser

                                                  =================================

Tarefa 2:
**Ter a tarefa 1 concluida**

Clicar no link Go back to list
Clicar na coluna “Search Name” e digitar o conteúdo do Name (Teste Sicredi)
Clicar no checkbox abaixo da palavra Actions
Clicar no botão Delete
Validar o texto “Are you sure that you want to delete this 1 item?” através de uma asserção para a popup que será apresentada
Clicar no botão Delete da popup, aparecerá uma mensagem dentro de um box verde na parte superior direito da tela. Adicione uma asserção na mensagem “Your data has been successfully deleted from the database.”
Fechar o browser



