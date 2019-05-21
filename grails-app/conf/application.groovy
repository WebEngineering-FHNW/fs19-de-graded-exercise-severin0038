
// Added by the Spring Security Core plugin:
grails.plugin.springsecurity.userLookup.userDomainClassName = 'webec.SecUser'
grails.plugin.springsecurity.userLookup.authorityJoinClassName = 'webec.SecUserSecRole'
grails.plugin.springsecurity.authority.className = 'webec.SecRole'

grails.plugin.springsecurity.logout.postOnly = false // allow logout via get url /logout

final statics = [
	[pattern: '/',               access: ['permitAll']],
	[pattern: '/error',          access: ['permitAll']],
	[pattern: '/index',          access: ['permitAll']],
	[pattern: '/listOfQuestions.gsp',      access: ['permitAll']],
	[pattern: '/shutdown',       access: ['permitAll']],
	[pattern: '/assets/**',      access: ['permitAll']],
	[pattern: '/**/js/**',       access: ['permitAll']],
	[pattern: '/**/css/**',      access: ['permitAll']],
	[pattern: '/**/images/**',   access: ['permitAll']],
	[pattern: '/**/favicon.ico', access: ['permitAll']]
]

grails.plugin.springsecurity.controllerAnnotations.staticRules = statics

grails.plugin.springsecurity.filterChain.chainMap = [
	[pattern: '/assets/**',      filters: 'none'],
	[pattern: '/**/js/**',       filters: 'none'],
	[pattern: '/**/css/**',      filters: 'none'],
	[pattern: '/**/images/**',   filters: 'none'],
	[pattern: '/**/favicon.ico', filters: 'none'],
	[pattern: '/**',             filters: 'JOINED_FILTERS']
]

// config types are 'Annotation', 'Requestmap', or 'InterceptUrlMap'
grails.plugin.springsecurity.securityConfigType = 'InterceptUrlMap'
grails.plugin.springsecurity.interceptUrlMap = statics + [
		//Diese Seiten werden für alle freigegeben, damit das Login/Logout einwandfrei funktioniert
		[pattern: "/static/**",                     access: ["permitAll"]],
		[pattern: "/login/auth",                    access: ["permitAll"]],
        [pattern: "/logout/**",                     access: ["permitAll"]],

		[pattern: "/question/create/**",    	    access: ['ROLE_ADMIN']],
		[pattern: "/question/show/**",		        access: ['ROLE_ADMIN']],
		[pattern: "/question/delete/**",        	access: ['ROLE_ADMIN']],
		[pattern: "/question/update/**",        	access: ['ROLE_ADMIN']],

		//Ein normaler User hat Zugriff auf seine offenen und bereits beantworteten Fragen...
		[pattern: "/question/**",        			access: ['ROLE_ADMIN', 'ROLE_NORMAL']],
//        [pattern: "/question/answeredQuestions",    access: ['ROLE_ADMIN', 'ROLE_NORMAL']],
		[pattern: "/",						        access: ['ROLE_ADMIN', 'ROLE_NORMAL']],

		//Die restlichen Seiten kann nur ein Administrator sehen
        [pattern: "/**",                            access: ['ROLE_ADMIN']], // default: all is secured
]
