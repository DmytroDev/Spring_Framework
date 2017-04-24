Steps:
1/ Install nodeJS
2/ Run "npm i"
3/ npm install jquery


H2 url masks:
Remote
jdbc:h2:tcp://{host::localhost}[:{port::9092}]/{database::default}[;<;,user={user:param},password={password:param},{:identifier}={:param}>]

In-memory
jdbc:h2:mem:{database::default}?[;<;,{:identifier}={:param}>]

Embedded:
jdbc:h2:!(tcp://)[file:]{path}[;<;,user={user:param},password={password:param},{:identifier}={:param}>]


embedded (local) connection(URL)
jdbc:h2:~/sofwarestore

in-memmory (URL)
jdbc:h2:mem:softwarestore
